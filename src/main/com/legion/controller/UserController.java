package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.Auditing;
import legion.entity.Userapply;
import legion.service.AuditingService;
import legion.service.PermissionService;
import legion.service.UserService;

import java.io.IOException;
import  java.util.Date;
import java.text.SimpleDateFormat;

import legion.util.UploadUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import legion.entity.User;
import legion.util.JWTUtil;
import legion.util.PasswordUtil;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private AuditingService auditingService;
    @Resource
    private PermissionService permissionService;


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
            obj.put("code",1);
            obj.put("username",user.getUsername());
            return obj;
        }
        else {
            obj.put("code",0);
        }

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

    @RequestMapping(value = "/getuserbyg",method = RequestMethod.GET)
    public JSONObject getalluserbyGroupid(@RequestParam(value= "groupid") Integer groupid,
                                          @RequestParam(value= "page") Integer page)
    {

        JSONObject obj = new JSONObject();
        Integer nowpage = 10*(page-1);
        ArrayList List = userService.listUserByGroupid(groupid, nowpage);
        obj.put("user",List);
        obj.put("length",userService.CountUserByGroupid(groupid));
        return obj;
    }

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public JSONObject getalluser(@RequestParam(value= "page") Integer page)
    {
        JSONObject obj = new JSONObject();
        Integer nowpage = 10*(page-1);
        obj.put("user",userService.listUser(nowpage));
        obj.put("length",userService.countuser());
        return obj;
    }

    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
    public Integer deleteuser(@PathVariable Integer id) {
        if (userService.deleteUser(id) == 1) {
            return 1;
        } else {
            return 1;
        }
    }

        @RequestMapping(value = "/updateinfo",method = RequestMethod.PATCH)
    public JSONObject getalluser(@RequestBody User user)
    {
        JSONObject obj =new JSONObject();
        obj.put("code",userService.updateUser(user));
        return obj;
    }


    @Transactional
    @RequestMapping(value = "/userapply",method = RequestMethod.POST)
            public Integer adduserapply(@RequestBody Userapply userapply)
    {
        Date startday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String cday = sdf.format(startday);

        Auditing auditing = new Auditing();
        auditing.setReason(userapply.getReason());
        auditing.setType("个人");
        auditing.setApplicant(userapply.getDate());
        auditing.setMoney(userapply.getMoney());
        auditing.setState("审核中");
        auditing.setDate(cday);
        userapply.setDate(cday);

         if(userService.addUserapply(userapply)==0){
             throw new RuntimeException();
         }
         else
         {
             auditing.setLinked(userapply.getId());
             if(auditingService.add(auditing)==0) {
                 throw new RuntimeException();
             }
         }
         return 1;
    }



    @RequestMapping(value = "/userapply",method =RequestMethod.PATCH)
    public Integer updateuserapply(@RequestBody Userapply userapply)
    {
        return  userService.updateUserapply(userapply);
    }

    @RequestMapping(value = "/userapply",method = RequestMethod.GET)
    public JSONObject getuserapply(@RequestParam(value= "username") String  username)
    {
        JSONObject obj = new JSONObject();
        obj.put("userapply",userService.listuserapply(username));
        obj.put("length",obj.size());
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

