package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.*;

import legion.service.FinanceService;
import legion.service.GoodsService;

import legion.service.ProjectService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.Resource;


@CrossOrigin
@RestController
//@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private ProjectService projectService;
    @Resource
    private FinanceService financeService;


    @RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
    public ArrayList goodsbyid(@PathVariable Integer id){
        ArrayList<Goods> list = new ArrayList<>();
            Goods goods = goodsService.listGoodsById(id);
                list.add(goods);
                return list;
    }

    @RequestMapping(value = "/goods/type/{type}",method = RequestMethod.GET)
    public ArrayList goodsbytype(@PathVariable Integer type){

        return goodsService.listGoodsByType(type);
    }

    @RequestMapping(value = "/goodsflow",method = RequestMethod.GET)
    public JSONObject goodsflow(@RequestParam(value = "page")Integer page){
        JSONObject object = new JSONObject();
        int nowpage = (page-1)*10;
         object.put("goodsflow" ,goodsService.listGoodsflow(nowpage));
        object.put("length",goodsService.goodsflownum());
        return  object;
    }

    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public JSONObject listgoods(@RequestParam(value = "page")Integer page){
        JSONObject object = new JSONObject();
        object.put("goods", goodsService.listGoods( (page-1)*10));
        object.put("length",goodsService.goodsnum());
        return  object;
    }

    @RequestMapping(value = "/goodsapply",method = RequestMethod.GET)
    public JSONObject listgoodsapply(@RequestParam(value = "page")Integer page){
        JSONObject  obj = new JSONObject();
        obj.put("GoodsApply", goodsService.listGoodsApply( (page-1)*10));
        obj.put("length",goodsService.goodsapplynum());
        return obj;
    }

    @Transactional
    @RequestMapping(value = "/goodsapply",method = RequestMethod.PATCH)
    public JSONObject listgoodsapply(@RequestBody GoodsApply goodsApply){
        JSONObject  obj = new JSONObject();
        String nowstate =goodsApply.getState();
        if(nowstate =="通过"|| nowstate.equals("通过"))
        {
            if(projectService.updategoodsapply(goodsApply)==0){
                throw new RuntimeException();
            }
            ProGoods proGoods =projectService.findprogoods(goodsApply.getProgoodsid());
            proGoods.setActualnum(proGoods.getApplynum()+proGoods.getActualnum());
            proGoods.setApplynum(0);
            if(projectService.updateprogressgoods(proGoods)==0){
                throw new RuntimeException();
            }
            Goods goods = goodsService.listGoodsById(goodsApply.getGoodsid());
            goods.setNumber(goods.getNumber()-goodsApply.getApplynum().intValue());
            goods.setLatelynum(-goodsApply.getApplynum().intValue());
            goods.setLatelydate(goodsApply.getDate());
            goods.setAdmin(goodsApply.getAdmin());
            if(goodsService.updateGoods(goods)==0){
                throw new RuntimeException();
            }
            if(goodsService.addGoodsflow(goods.getId(),goods.getLatelynum(),goods.getLatelydate(),
                    goodsApply.getAdmin(),goodsApply.getReason())==0){
                throw new RuntimeException();
            }
            obj.put("code",1);
            obj.put("result","审核结果通过");
        }
        else if(nowstate =="不通过" || nowstate.equals("不通过"))
        {
            if(projectService.updategoodsapply(goodsApply)==0)
            {
                throw new RuntimeException();
            }
            ProGoods proGoods =projectService.findprogoods(goodsApply.getProgoodsid());

            proGoods.setApplynum(0);
            if(projectService.updateprogressgoods(proGoods )==0){
                throw new RuntimeException();
            }
            obj.put("code",1);
            obj.put("result","审核结果不通过");
        }

        return obj;
    }

    @Transactional
    @RequestMapping(value = "/goods/{money}",method = RequestMethod.POST)
    public Integer addgoods(@RequestBody Goods goods,@PathVariable double money ){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startday = new Date();
        goods.setLatelynum(goods.getNumber());
        goods.setLatelydate(format.format(startday));
        if(goodsService.addGoods(goods)==0){
            throw new RuntimeException();
        }
        Finance finance = new Finance();
        finance.setMoney(money*goods.getNumber());
        finance.setDescs("购买"+goods.getName()+":("+goods.getNumber()+"*"+money+")");
        finance.setDate(format.format(startday));
        finance.setType("仓储");
        finance.setAdmin(goods.getAdmin());
        GoodsFlow goodsFlow = new GoodsFlow();
        if (financeService.addFinance(finance) == 0) {
            throw new RuntimeException();
        }

        else if (goodsService.addGoodsflow(goods.getId(), goods.getNumber(),
                format.format(startday) , goods.getAdmin(), "商品入仓") == 0) {
            throw new RuntimeException();
        }
        return 1;
}

    @RequestMapping(value ="/goods",method = RequestMethod.PATCH)
    public Integer updategoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods);
    }

    @RequestMapping(value = "/goods/{id}",method = RequestMethod.DELETE)
    public Integer deletegoods(@PathVariable Integer id)
    {
        return goodsService.deleteGoods(id);
    }




}
