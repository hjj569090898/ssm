package legion.controller;

import legion.util.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @PostMapping("/avatar")
    @ResponseBody
    public Map upload(MultipartFile file, HttpServletRequest request,@RequestParam(value = "username" )String username){
        Map<String,Object> map  =new HashMap<String, Object>();
        try{
            String path = request.getSession().getServletContext().getRealPath("\\avatar\\");
            String path2 = "C:\\legion\\src\\assets\\pimage";
            String image = UploadUtil.avatarupload(file,path2,username);

            map.put("code",0);
            map.put("image",image);

        }catch (IOException e){
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request,
                      @RequestParam(value = "id" )Integer id){
        Map<String,Object> map  =new HashMap<String, Object>();
        String path = request.getSession().getServletContext().getRealPath("\\progressimage\\");
        String path2 = "C:\\legion\\src\\assets\\pimage";
        try {
//            ArrayList<String>  list = UploadUtil.upload(files, path, id);
            map.put("code",0);
            map.put("imagelist",UploadUtil.upload(files, path2, id));
        }catch (IOException e){
            map.put("code",1);
            e.printStackTrace();
        }
        return map;
    }
}
