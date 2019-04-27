package legion.controller;

import legion.entity.StockIn;
import legion.service.StockInService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;


@CrossOrigin
@RestController
public class StockInController {
    @Resource
    private StockInService stockInService;
    @RequestMapping(value = "/stockin/{id}",method = RequestMethod.GET)
    public ArrayList stockinbyid(@PathVariable Integer id){
        ArrayList<StockIn> list = new ArrayList<>();
        StockIn stockIn = stockInService.listStockInById(id);
                list.add(stockIn);
                return list;
    }

    @RequestMapping(value = "/stockin",method = RequestMethod.GET)
    public ArrayList liststockin(@RequestParam(value = "state",defaultValue ="%")String state,
                                 @RequestParam(value = "page")Integer page){
        Integer nowpage = 10*(page-1);
        if(state==null) {state="%";}
        ArrayList<StockIn> list = stockInService.listStockIn(state, nowpage);
//        Integer allnum = stockInService.listallpage();
        return list;
    }

    @RequestMapping(value = "/stockin",method = RequestMethod.POST)
    public Integer addstcokin(@RequestBody StockIn stockIn ){
        return stockInService.addStockIn(stockIn);
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
