package legion.controller;

import legion.entity.StockOut;
import legion.service.StockOutService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;


@CrossOrigin
@RestController
public class StockOutController {
    @Resource
    private StockOutService stockOutService;
    @RequestMapping(value = "/stockout/{id}",method = RequestMethod.GET)
    public ArrayList stockoutbyid(@PathVariable Integer id){
        ArrayList<StockOut> list = new ArrayList<>();
        StockOut stockIn = stockOutService.listStockOutById(id);
                list.add(stockIn);
                return list;
    }

    @RequestMapping(value = "/stockout",method = RequestMethod.GET)
    public ArrayList liststockin(@RequestParam(value = "state",defaultValue ="%")String state,
                                 @RequestParam(value = "page")Integer page){
        Integer nowpage = 10*(page-1);
        if(state==null) {state="%";}
        ArrayList<StockOut> list = stockOutService.listStockOut(state, nowpage);
        return list;
    }

    @RequestMapping(value = "/stockout",method = RequestMethod.POST)
    public Integer addstcokin(@RequestBody StockOut stockOut ){
        return stockOutService.addStockOut(stockOut);
    }

    @RequestMapping(value ="/stockout",method = RequestMethod.PATCH)
    public Integer updatestockin(@RequestBody StockOut stockIn){
        return stockOutService.updateStockOut(stockIn);
    }

    @RequestMapping(value = "/stockout/{id}",method = RequestMethod.DELETE)
    public Integer deletestockin(@PathVariable Integer id)
    {
        return stockOutService.deleteStockOut(id);
    }


}
