package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.service.UserService;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


import legion.entity.User;
import legion.util.JWTUtil;
import legion.util.PasswordUtil;

@CrossOrigin
@RestController
public class UserController {
    @Resource
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(@RequestBody User user) {
        JSONObject obj = new JSONObject();
        User isuser = userService.listUserByName(user.getUsername()); //判断用户是否存在
        if (isuser == null) {
            obj.put("result", "不存在该用户！");
            return obj;
        } else if (!PasswordUtil.verify(user.getPassword(),isuser.getPassword()))
        {
            obj.put("result", "username or password is false");
            return obj;
        } else {
            String jwt = JWTUtil.sign(isuser.getUsername(), isuser.getEmail());//自定义JWT
            obj.put("User",isuser.getUsername());
            obj.put("jwt", jwt);
            return obj;
        }
    }

    @RequestMapping(value = "/username",method = RequestMethod.GET)
    public JSONObject username(@RequestParam(value = "username")String username)
    {
        User isuser = userService.listUserByName(username);
        JSONObject obj = new JSONObject();
        if(isuser !=null)
        {
            obj.put("isexits","1");
            obj.put("result","该用户已存在，请重新输入用户名！");
        }else {
            obj.put("isexits","0");
            obj.put("result","此用户名可以注册！");
        }
        return obj;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JSONObject register(@RequestBody User user)
    {
        String mds = PasswordUtil.generate(user.getPassword());//生成有随机盐的密码
        user.setPassword(mds);
        JSONObject obj = new JSONObject();
        if(userService.addUser(user)==1){
            obj.put("success","注册成功!");
            return obj;
        }
        obj.put("fali","注册失败!");
        return obj;
    }

    @RequestMapping(value = "/resetpw",method = RequestMethod.POST)
    public JSONObject resetpw(@RequestBody User user)
    {
        String mds = PasswordUtil.generate(user.getPassword());//生成有随机盐的密码
        user.setPassword(mds);
        JSONObject obj = new JSONObject();

        return obj;
    }

    @RequestMapping(value = "/userinfobyname",method = RequestMethod.GET)
    public JSONObject userinfobyname(@RequestParam(value = "username")String username)
    {
        User user = userService.listUserByName(username);
        user.setPassword("******");
        JSONObject obj = new JSONObject();
        obj.put("info",user);
        return obj;
    }

}
//            Subject subject = SecurityUtils.getSubject();
//            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(isuser.getUsername(), isuser.getPassword());
//            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(jwt,jwt);
//            obj.put("aa",usernamePasswordToken);
//            try {
////                subject.login(usernamePasswordToken);
//                obj.put("jwt", jwt);
//                return obj;
//            } catch (Exception e) {
//                obj.put("fail", isuser.getUsername());
//                return obj;
//            }

