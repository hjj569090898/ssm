package legion.dao;

import legion.entity.Goods;
import legion.entity.GoodsApply;
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

    Integer goodsflownum();

    Integer updateGoods(Goods goods);

    Integer deleteGoods(@Param("id") Integer id);

    Goods listGoodsById(@Param("id") Integer id);

    Integer goodsnum();

    ArrayList<Goods> listGoods(@Param("page") Integer page);

    ArrayList<Goods> listGoodsByType(@Param("type") Integer type);

    ArrayList<GoodsApply> listGoodsApply(@Param("page") Integer page);

    Integer Goodsapplynum();

}
