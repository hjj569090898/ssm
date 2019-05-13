package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.*;

import  java.util.Date;

import legion.service.GoodsService;
import legion.service.ProgressService;
import legion.service.ProjectService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@CrossOrigin
@RestController

public class ProgressController {
    @Resource
    private ProgressService progressService;
    @Resource
    private ProjectService projectService;
    @Resource
    private GoodsService goodsService;

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

    @RequestMapping(value = "/projectgoods",method = RequestMethod.GET)
    public JSONObject ListProjectgoods(
            @RequestParam(value = "projectid")Integer projectid,
            @RequestParam(value = "page")Integer page){
        JSONObject object = new JSONObject();
        ArrayList List = progressService.listProgoods(projectid,10*(page-1));
        object.put("Progoods",List);
        object.put("page",List.toArray().length);
        return object;
    }

    @Transactional
    @RequestMapping(value = "/projectgoods",method = RequestMethod.POST)
    //新增加物资需求
    public JSONObject addProjectgoods(@RequestBody ProGoods proGoods){
        JSONObject object = new JSONObject();
        Date startday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String cday = sdf.format(startday);
        proGoods.setDate(cday);
        if(projectService.addprojectgoods(proGoods)==0){
            throw new RuntimeException();
        }
        GoodsApply goodsApply =new GoodsApply();
        goodsApply.setApplynum(proGoods.getApplynum());
        goodsApply.setDate(proGoods.getDate());
        goodsApply.setGoodsid(proGoods.getGoodsid());
        goodsApply.setProjectid(proGoods.getProjectid());
        goodsApply.setState("审核中");
        goodsApply.setReason("工程计划所需");
        goodsApply.setProgoodsid(proGoods.getId());
        if(projectService.addprojectapply(goodsApply)==0)
        {
            throw new RuntimeException();
        }
        object.put("code",1);
        return object;
    }

    @Transactional
    @RequestMapping(value = "/addprojectgoods",method = RequestMethod.PATCH)
    public JSONObject newaddgoods(@RequestBody ProGoods proGoods){
        JSONObject object = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startday = new Date();
        proGoods.setDate(format.format(startday));
        progressService.newaddgoods(proGoods);
        GoodsApply goodsApply =new GoodsApply();
        goodsApply.setApplynum(proGoods.getApplynum());
        goodsApply.setDate(proGoods.getDate());
        goodsApply.setGoodsid(proGoods.getGoodsid());
        goodsApply.setProjectid(proGoods.getProjectid());
        goodsApply.setState("审核中");
        goodsApply.setReason("需求新增");
        goodsApply.setProgoodsid(proGoods.getId());
        if(projectService.addprojectapply(goodsApply)==0)
        {
            throw new RuntimeException();
        }
        object.put("code",1);
        return object;
    }

    @Transactional
    @RequestMapping(value = "/deleteprojectgoods",method = RequestMethod.PATCH)
    public JSONObject deletprojectgoods(@RequestBody ProGoods proGoods,
                                        @RequestParam(value = "deletenum") Integer deletenum,
                                        @RequestParam(value = "admin") String admin
    ){

        JSONObject object = new JSONObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startday = new Date();
        String nowtime = format.format(startday);
        proGoods.setDate(nowtime);
        proGoods.setActualnum(proGoods.getActualnum()-deletenum);
        if(progressService.deleteprojectgoods(proGoods)==0){
            throw new RuntimeException();
        }
        Goods goods = goodsService.listGoodsById(proGoods.getGoodsid());
        goods.setLatelynum(deletenum);
        goods.setLatelydate(nowtime);
        goods.setAdmin(admin);
        goods.setNumber(goods.getNumber()+deletenum);
        if(goodsService.updateGoods(goods)==0)
        {
            throw new RuntimeException();
        }
        if(goodsService.addGoodsflow(goods.getId(),deletenum,nowtime,admin,"工程退料")==0){
            throw new RuntimeException();
        }
        object.put("code",1);
        return object;
    }

    @RequestMapping(value = "/progress",method = RequestMethod.POST)
    public Integer addProgress(@RequestBody Progress progress ){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startday = new Date();
        progress.setDate(format.format(startday));
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
