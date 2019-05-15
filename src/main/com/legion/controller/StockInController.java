package legion.controller;

import com.alibaba.fastjson.JSONObject;
import legion.entity.StockIn;
import legion.entity.Auditing;
import legion.service.AuditingService;
import legion.service.StockInService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;


@CrossOrigin
@RestController
public class StockInController {
    @Resource
    private StockInService stockInService;
    @Resource
    private AuditingService auditingService;

    @RequestMapping(value = "/stockin/{id}",method = RequestMethod.GET)
    public JSONObject stockinbyid(@PathVariable Integer id){
        JSONObject object = new JSONObject();
        ArrayList<StockIn> list = new ArrayList<>();
        StockIn stockIn = stockInService.listStockInById(id);
        if(stockIn == null)
        {
            object.put("code",0);
            return object;
        }
                list.add(stockIn);
        object.put("code",1);
        object.put("stockin",list);
                return object;
    }

    @RequestMapping(value = "/stockin",method = RequestMethod.GET)
    public JSONObject liststockin(@RequestParam(value = "state")String state,
                                  @RequestParam(value = "page")Integer page){
        JSONObject json = new JSONObject();
        Integer nowpage = 10*(page-1);

        if(state==""||state.equals("")) {
            state ="%";
            ArrayList<StockIn> list = stockInService.listStockIn(state, nowpage);
            json.put("Stockin",list);
            json.put("length",stockInService.listallpage());
        }
        else{
            ArrayList<StockIn> list = stockInService.listStockIn(state, nowpage);
            json.put("Stockin",list);
            json.put("length",list.toArray().length);}
        return json;
    }

    @Transactional
    @RequestMapping(value = "/stockin",method = RequestMethod.POST)
    public Integer addstcokin(@RequestBody StockIn stockIn ){
        stockInService.addStockIn(stockIn);
        Auditing auditing = new Auditing();
        auditing.setLinked(stockIn.getId());
        auditing.setDate(stockIn.getDate());
        auditing.setApplicant(stockIn.getApplicant());
        auditing.setMoney(stockIn.getAllprice());
        auditing.setReason(stockIn.getReason());
        auditing.setType("仓储入库");
        auditing.setState("审核中");
        if(auditingService.add(auditing) ==0){
            throw new RuntimeException();
        }
        return 1;
    }


    @RequestMapping(value ="/stockin",method = RequestMethod.PATCH)
    public Integer updatestockin(@RequestBody StockIn stockIn){
        return stockInService.updateStockIn(stockIn);
    }

    @RequestMapping(value = "/stockin/{id}",method = RequestMethod.DELETE)
    public Integer deletestockin(@PathVariable Integer id)
    {
        return stockInService.deleteStockIn(id);
    }


}
