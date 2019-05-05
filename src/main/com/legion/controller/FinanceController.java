package legion.controller;

import com.alibaba.fastjson.JSONObject;
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
    public JSONObject listFinance(@RequestParam(value = "type")String type,
                                  @RequestParam(value = "page")Integer page){
        if(type ==null || type.equals(""))
        {
            type = "%%";
        }
        Integer nowpage = 10*(page-1);
        ArrayList<Finance> list = financeService.listFinance(type,nowpage);
        JSONObject object = new JSONObject();
        object.put("Fiance",list);
        object.put("length",list.toArray().length);
        return object;
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
