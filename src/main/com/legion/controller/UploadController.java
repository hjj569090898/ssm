package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.service.ProjectService;
import legion.util.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/avatar/{username}")
    @ResponseBody
    public Map upload(MultipartFile file, HttpServletRequest request,@PathVariable String username){
        Map<String,Object> map  =new HashMap<String, Object>();
        try{
//            String path = request.getSession().getServletContext().getRealPath("\\avatar\\");
//            String path = "D:\\vue1\\vuelegion\\src\\assets\\avatar";
            String path = "C:\\legion\\src\\assets\\avatar";
//            "D:\\vue1\\\vuelegion\\src\\assets\\avatar"
            String image = UploadUtil.avatarupload(file,path,username);

            map.put("code",0);
            map.put("image",image);

        }catch (IOException e){
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }

    @Transactional
    @PostMapping("/upload/{id}")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request,
                      @PathVariable Integer id){


        Map<String,Object> map  =new HashMap<String, Object>();
//        String path = request.getSession().getServletContext().getRealPath("\\progressimage\\");
        String path2 = "C:\\legion\\static\\image";
        String path = "D:\\vue1\\vuelegion\\static\\image";

        try {
            String url = "./static/image/"+UploadUtil.upload(files, path2, id);
            Integer a = projectService.addimageurl(id,url);
            map.put("code",a);
        }catch (IOException e){

        }
        return map;
    }

    @GetMapping("/getimage")
    @ResponseBody
    public JSONObject geiimage(@RequestParam("projectid") Integer projectid){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url",projectService.listimageurl(projectid));
        return jsonObject;
    }
}
