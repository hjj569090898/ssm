package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.Project;
import legion.entity.ProjectCount;
import legion.service.ProjectService;
import legion.util.DateUtil;
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
        object.put("progress", projectService.listProject(nowpage));
        object.put("length",List.toArray().length);
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

    @RequestMapping(value = "/projectcount/{projectid}",method = RequestMethod.GET)
    public JSONObject ProjectCount(@PathVariable Integer projectid)
    {
        ProjectCount projectCount  =  projectService.listProjectCount(projectid);
        JSONObject obj = new JSONObject();
        long aday;
        long pday;
        long delaystart;
        long delayend;
        Project project = projectService.listProjectById(projectid);
        if(project.getActualstart().equals("")||project.getActualstart()==null
                ||project.getActualend().equals("")||project.getActualend()==null){
            aday =0;
        }
        else {
         aday =DateUtil.getDaySub(project.getActualstart(),project.getActualend());
        }
         pday =DateUtil.getDaySub(project.getPlanstart(),project.getPlanend());
        delaystart = DateUtil.getDaySub(project.getActualstart(),project.getPlanstart());
        delayend = DateUtil.getDaySub(project.getActualend(),project.getPlanend());

        Double all[] = new Double[3];
        Double plan[] = new Double[3];
        Double now[] = new Double[3];

        all[0] = (double)pday;
        all[1] = projectCount.getPlancost();
        all[2] = projectCount.getPlanworking();

        plan[0] = (double)pday*projectCount.getAllpercent()/100;
        plan[1] = projectCount.getPlancost()*projectCount.getAllpercent()/100;
        plan[2] = projectCount.getPlanworking()*projectCount.getAllpercent()/100;

        now[0] =(double)aday;
        now[1] = projectCount.getAccost();
        now[2] = projectCount.getAcworking();
        obj.put("all",all);
        obj.put("plan",plan);
        obj.put("now",now);
        obj.put("percent",projectCount.getAllpercent());
        obj.put("delaystart",delaystart);
        obj.put("delayend",delayend);
        obj.put("subcost",projectCount.getSubcost());
        obj.put("progressnum",projectCount.getProgressnum());
        obj.put("plancost",projectCount.getPlancost());
        obj.put("accoust",projectCount.getAccost());
        obj.put("planwork",projectCount.getPlanworking());
        obj.put("acwork",projectCount.getPlanworking());
        obj.put("aday",aday);
        obj.put("pday",pday);
        return  obj;
    }


}
