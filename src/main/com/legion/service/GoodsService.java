package legion.service;
import legion.entity.Goods;

import java.util.ArrayList;
import java.util.List;

public interface GoodsService {
    public Integer addGoods(Goods goods);

    public Integer updateGoods(Goods goods);

    public Integer deleteGoods(Integer id);

    public Goods listGoodsById(Integer Goodsid);

    public ArrayList<Goods> listGoods();

    public ArrayList<Goods>listGoodsByType(Integer type);
}
