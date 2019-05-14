package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.Finance;
import legion.entity.Project;
import legion.entity.ProjectCount;
import legion.service.FinanceService;
import legion.service.ProjectService;
import legion.util.DateUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController

public class ProjectController {
    @Resource
    private ProjectService projectService;
    @Resource
    private FinanceService financeService;


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
    public JSONObject updateProject(@RequestBody Project project){
        JSONObject object = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startday = new Date();
        String nowtime = format.format(startday);
        String state = project.getPnow();
        if(state=="已验收"||state.equals("已验收")) {
            if (projectService.updateProject(project) == 0) {
                throw new RuntimeException();
            }
            Finance finance = new Finance();
            finance.setAdmin(project.getLeader());
            finance.setDate(nowtime);
            finance.setDescs("工程编号：" + project.getId() + "的验收结算");
            finance.setMoney(project.getMoney() + 0.0);
            finance.setType("合同结算");

            if (financeService.addFinance(finance) == 0) {
                throw new RuntimeException();
            }
            object.put("code", 1);
        }
        else{
            if (projectService.updateProject(project) == 0) {
                throw new RuntimeException();
            }
        }
        object.put("code",2);
        return  object;
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
        Double all[] = new Double[3];
        Double plan[] = new Double[3];
        Double now[] = new Double[3];
        Integer progressnum = projectCount.getProgressnum(); //用来判别没任务的情况下

        JSONObject obj = new JSONObject();
        long aday;
        long pday;
        long delaystart;
        long delayend;

        Project project = projectService.listProjectById(projectid);
        String pandingstart = project.getActualend();
        String pandingend = project.getActualend();

        if(progressnum ==0)
        {
            all[0] = 0.0;
            all[1] = 0.0;
            all[2] = 0.0;


            plan[0] = 0.0;
            plan[1] = 0.0;
            plan[2] = 0.0;

            now[0] =0.0;
            now[1] = 0.0;
            now[2] = 0.0;


            obj.put("all",all);
            obj.put("plan",plan);
            obj.put("now",now);
            obj.put("percent",0);
            obj.put("delaystart",0);
            obj.put("delayend",0);
            obj.put("subcost",0);
            obj.put("progressnum",0);
            obj.put("plancost",0);
            obj.put("accoust",0);
            obj.put("planwork",0);
            obj.put("acwork",0);
            obj.put("aday",0);
            obj.put("pday",0);
            return  obj;
        }

        if(pandingstart.equals("")||pandingstart==null
                ||pandingend.equals("")||pandingend==null){
            aday =0;
        }
        else {
         aday =DateUtil.getDaySub(project.getActualstart(),project.getActualend()); //实际完工时长
        }
         pday =DateUtil.getDaySub(project.getPlanstart(),project.getPlanend());  //计划完工时长
        delaystart = DateUtil.getDaySub(project.getActualstart(),project.getPlanstart());  //开工延期时长
        delayend = DateUtil.getDaySub(project.getActualend(),project.getPlanend());       //竣工延期时长



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
        obj.put("acwork",projectCount.getAcworking());
        obj.put("aday",aday);
        obj.put("pday",pday+1);
        return  obj;
    }

    @RequestMapping(value = "/pimage",method = RequestMethod.GET)
    public JSONObject Listimage(
            @RequestParam(value = "projectid")Integer projectid){
        JSONObject object = new JSONObject();
         List list = projectService.listimageurl(projectid);
        object.put("imageurl",list);
        return object;
    }

}
