package legion.dao;

import legion.entity.Goods;
import legion.entity.GoodsFlow;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GoodsDao {
    Integer addGoods(Goods goods);

    Integer addGoodsflow(@Param("goodsid") Integer goodsid,@Param("num") Integer num,
    @Param("date") String date,@Param("admin") String admin,@Param("descs") String descs);

    ArrayList<GoodsFlow> listGoodsflow(@Param("page") Integer page);

    Integer updateGoods(Goods goods);

    Integer deleteGoods(@Param("id") Integer id);

    Goods listGoodsById(@Param("id") Integer id);

    ArrayList<Goods> listGoods();

    ArrayList<Goods> listGoodsByType(@Param("type") Integer type);


}
