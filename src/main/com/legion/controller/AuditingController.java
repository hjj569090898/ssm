package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.Auditing;
import legion.entity.Finance;
import legion.entity.StockIn;
import legion.entity.Goods;
import legion.service.AuditingService;
import legion.service.FinanceService;
import legion.service.GoodsService;
import legion.service.StockInService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@CrossOrigin
@RestController

public class AuditingController {
    @Resource
    private AuditingService auditingService;
    @Resource
    private FinanceService financeService;
    @Resource
    private StockInService stockInService;
    @Resource
    private GoodsService goodsService;

    @RequestMapping(value = "/auditing/{id}",method = RequestMethod.GET)
    public ArrayList auditingbyid (@PathVariable Integer id){
        ArrayList<Auditing> list = new ArrayList<>();
        Auditing auditing = auditingService.QueryAuditing(id);
                list.add(auditing);
                return list;
    }

    @RequestMapping(value = "/auditing",method = RequestMethod.GET)
    public JSONObject listauditing(@RequestParam(value = "type")String type,
                                  @RequestParam(value = "state") String state,
                                  @RequestParam(value = "page")Integer page){
        if(type ==null || type.equals(""))
        {
            type = "%%";
        }if(state ==null || state.equals(""))
        {
            state = "%%";
        }
        ArrayList<Auditing> list = auditingService.listAuditing(type,state,10*(page-1));
        JSONObject object = new JSONObject();
        object.put("auditing",list);
        object.put("length",list.toArray().length);
        return object;
    }

    @Transactional
    @RequestMapping(value ="/auditing",method = RequestMethod.PATCH)
    public Integer updateFinance(@RequestParam(value = "admin")String admin,
                                 @RequestParam(value = "advice") String advice,
                                 @RequestParam(value = "state") String state,
                                 @RequestParam(value = "adate")String adate,
                                 @RequestParam(value = "id") Integer id ){
         auditingService.update(admin,advice,state,adate,id);

         if(state =="通过"|| state.equals("通过")) {
             Finance finance = new Finance();
             Auditing auditing = auditingService.QueryAuditing(id);
             finance.setAdmin(auditing.getAdmin());
             finance.setMoney(auditing.getMoney());
             finance.setDate(auditing.getAdate());
             finance.setType(auditing.getType());
             finance.setDescs("申请原因:"+auditing.getReason());
             StockIn stockIn =stockInService.listStockInById(auditing.getLinked());
             stockIn.setState("申请通过");
             //审核通过  1.更新审核单状态------2更新入库订单申请单----3更新财务流水---4更新库存
             Goods goods = goodsService.listGoodsById(stockIn.getGoodsid());
             goods.setLatelynum(stockIn.getNum());
             goods.setLatelydate(auditing.getAdate());
             goods.setAdmin(stockIn.getApplicant());
             goods.setNumber(goods.getNumber()+ stockIn.getNum());
             if (financeService.addFinance(finance) == 0){
                 throw new RuntimeException();
             }
             else if(stockInService.updateStockIn(stockIn)==0 ) {
                 throw new RuntimeException();
             }
             else if(goodsService.updateGoods(goods)==0)
             {
                 throw new RuntimeException();
             }
             else if(goodsService.addGoodsflow(stockIn.getGoodsid(),stockIn.getNum(),
                     auditing.getAdate(),stockIn.getApplicant(),stockIn.getReason())==0){
                 throw new RuntimeException();
             }
         }
         else if(state=="不通过" || state.equals("不通过")) {
            //审核不通过，1更新审核单状态  2 更新入库订单申请
             Auditing auditing = auditingService.QueryAuditing(id);
             StockIn stockIn =stockInService.listStockInById(auditing.getLinked());
             stockIn.setState("申请失败");
             if(stockInService.updateStockIn(stockIn)==0){
                 throw new RuntimeException();
             }
         }
         return 1;
    }





}
