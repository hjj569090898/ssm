package legion.dao;

import legion.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface GoodsDao {
    Integer addGoods(Goods goods);

    Integer updateGoods(Goods goods);

    Integer deleteGoods(@Param("id") Integer id);

    Goods listGoodsById(@Param("id") Integer id);

    ArrayList<Goods> listGoods();

    ArrayList<Goods> listGoodsByType(@Param("type") Integer type);


}
