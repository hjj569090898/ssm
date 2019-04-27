package legion.controller;

import legion.entity.Finance;
import legion.service.FinanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@CrossOrigin
@RestController

public class FinanceController {
    @Resource
    private FinanceService financeService;
    @RequestMapping(value = "/finance/{id}",method = RequestMethod.GET)
    public ArrayList Financebyid(@PathVariable Integer id){
        ArrayList<Finance> list = new ArrayList<>();
        Finance finance = financeService.listFinanceById(id);
                list.add(finance);
                return list;
    }

    @RequestMapping(value = "/finance",method = RequestMethod.GET)
    public ArrayList listFinance(@RequestParam(value = "symbol")String symbol,
                                 @RequestParam(value = "money")Double money,
                                 @RequestParam(value = "page")Integer page){
        Integer nowpage = 10*(page-1);
        ArrayList<Finance> list = new ArrayList<>();
        list = financeService.listFinance(symbol, money,nowpage);
        return list;
    }
    @RequestMapping(value = "/finance",method = RequestMethod.POST)
    public Integer addFinance(@RequestBody Finance finance ){
        return financeService.addFinance(finance);
    }

    @RequestMapping(value ="/finance",method = RequestMethod.PATCH)
    public Integer updateFinance(@RequestBody Finance finance){
        return financeService.updateFinance(finance);
    }

    @RequestMapping(value = "/finance/{id}",method = RequestMethod.DELETE)
    public Integer deleteFinance(@PathVariable Integer id)
    {
        return financeService.deleteFinance(id);
    }


}
