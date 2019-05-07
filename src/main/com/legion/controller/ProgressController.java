package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.Progress;
import legion.service.ProgressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@CrossOrigin
@RestController

public class ProgressController {
    @Resource
    private ProgressService progressService;

    @RequestMapping(value = "/aprogress",method = RequestMethod.GET)
    public ArrayList AProgress( @RequestParam(value = "id")Integer id,
                                @RequestParam(value = "projectid")Integer projectid){
        ArrayList<Progress> list = new ArrayList<>();
        Progress progress = progressService.listProgressById(id,projectid);
        list.add(progress);
        return list;
    }

    @RequestMapping(value = "/progress",method = RequestMethod.GET)
    public JSONObject ListProgress(
            @RequestParam(value = "projectid")Integer projectid,
            @RequestParam(value = "page")Integer page){
        Integer nowpage = 10*(page-1);
        JSONObject object = new JSONObject();
        ArrayList List = progressService.listProgress(projectid,nowpage);
        object.put("Project",List);
        object.put("page",List.toArray().length);
        return object;
    }

    @RequestMapping(value = "/progress",method = RequestMethod.POST)
    public Integer addProgress(@RequestBody Progress progress ){
        return progressService.addProgress(progress);
    }

    @RequestMapping(value ="/progress",method = RequestMethod.PATCH)
    public Integer updateProgress(@RequestBody Progress progress){
        return progressService.updateProgress(progress);
    }

    @RequestMapping(value = "/progress/{id}",method = RequestMethod.DELETE)
    public Integer deleteProgress(@PathVariable Integer id)
    {
        return progressService.deleteProgress(id);
    }
}
