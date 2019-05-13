package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.service.PermissionService;
import legion.entity.User;
import legion.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class PermissionController {
    @Resource
    private PermissionService permissionService;
    @Resource
    private UserService userService;

    @RequestMapping(value = "/userpermission", method = RequestMethod.GET)
    public JSONObject userper(@RequestParam(value = "username") String username) {
        JSONObject obj = new JSONObject();
        obj.put("permission", permissionService.userper(username));
        obj.put("groupmission",permissionService.usergroupper(username));
        return obj;
    }

    @Transactional
    @RequestMapping(value = "/addpermission",method = RequestMethod.POST)
    public JSONObject addpermission(@RequestParam("permission") String[] permission,
                                    @RequestParam(value = "username") String username){
        JSONObject obj = new JSONObject();
        User user =userService.listUserByName(username);
        Integer userid = user.getId();
        permissionService.deletepermission(userid);
        for(int i=0;i<permission.length;i++)
        {
            if(permissionService.addpermission(permission[i],userid)==0){
                 throw new RuntimeException();
            }
        }
        obj.put("code",1);
        return obj;
    }
}

