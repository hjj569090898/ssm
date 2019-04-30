package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.Project;
import legion.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@CrossOrigin
@RestController

public class ProjectController {
    @Resource
    private ProjectService projectService;
    @RequestMapping(value = "/project/{id}",method = RequestMethod.GET)
    public ArrayList AProject(@PathVariable Integer id){
        ArrayList<Project> list = new ArrayList<>();
        Project project = projectService.listProjectById(id);
                list.add(project);
                return list;
    }

    @RequestMapping(value = "/project",method = RequestMethod.GET)
    public JSONObject ListProject(
                                 @RequestParam(value = "page")Integer page){
        Integer nowpage = 10*(page-1);
        JSONObject object = new JSONObject();
        ArrayList List = projectService.listProject(nowpage);
        object.put("Project",List);
        object.put("page",List.toArray().length);
        return object;
    }
    @RequestMapping(value = "/project",method = RequestMethod.POST)
    public Integer addProject(@RequestBody Project project ){
        return projectService.addProject(project);
    }

    @RequestMapping(value ="/project",method = RequestMethod.PATCH)
    public Integer updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }

    @RequestMapping(value = "/project/{id}",method = RequestMethod.DELETE)
    public Integer deleteProject(@PathVariable Integer id)
    {
        return projectService.deleteProject(id);
    }


}
