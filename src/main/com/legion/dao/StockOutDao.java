package legion.dao;

import legion.entity.StockOut;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StockOutDao {
    Integer addStockOut(StockOut stockOut);

    Integer updateStockOut(StockOut stockOut);

    Integer deleteStockOut(@Param("id") Integer id);

    StockOut listStockOutById(@Param("id") Integer id);

    ArrayList<StockOut> listStockOut(@Param("state") String state, @Param("page") Integer page);

    Integer listallpage(@Param("state") String state);
}
