package legion.dao;

import legion.entity.StockIn;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StockInDao {
    Integer addStockIn(StockIn stockin);

    Integer updateStockIn(StockIn stockin);

    Integer deleteStockIn(@Param("id") Integer id);

    StockIn listStockInById(@Param("id") Integer id);

    ArrayList<StockIn> listStockIn(@Param("state") String state,@Param("page") Integer page );

    Integer listallpage();
}
