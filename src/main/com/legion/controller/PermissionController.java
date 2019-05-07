package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.service.PermissionService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @RequestMapping(value = "/userpermission", method = RequestMethod.GET)
    public JSONObject userper(@RequestParam(value = "username") String username) {
        JSONObject obj = new JSONObject();
        obj.put("permission", permissionService.userper(username));
        obj.put("groupmission",permissionService.usergroupper(username));
        return obj;
    }
}

