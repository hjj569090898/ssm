package legion.controller;

import legion.entity.Goods;

import legion.service.GoodsService;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import javax.annotation.Resource;


@CrossOrigin
@RestController
//@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
    public ArrayList goodsbyid(@PathVariable Integer id){
        ArrayList<Goods> list = new ArrayList<>();
            Goods goods = goodsService.listGoodsById(id);
                list.add(goods);
                return list;
    }

    @RequestMapping(value = "/goods/type/{type}",method = RequestMethod.GET)
    public ArrayList goodsbytype(@PathVariable Integer type){
        ArrayList<Goods> list = new ArrayList<>();
        list = goodsService.listGoodsByType(type);
        return list;
    }

    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public ArrayList listgood(){
        ArrayList<Goods> list = new ArrayList<>();
        list = goodsService.listGoods();
        return list;
    }
    @RequestMapping(value = "/goods",method = RequestMethod.POST)
    public Integer addgoods(@RequestBody Goods goods ){
        return goodsService.addGoods(goods);
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
