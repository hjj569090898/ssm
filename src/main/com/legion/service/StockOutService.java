package legion.service;
import legion.entity.StockOut;

import java.util.ArrayList;

public interface StockOutService {
     Integer addStockOut(StockOut stockout);

    public Integer updateStockOut(StockOut stockout);

    public Integer deleteStockOut(Integer id);

    public StockOut listStockOutById(Integer id);

    public ArrayList<StockOut> listStockOut(String state, Integer page);

    public Integer listallpage(String state);
}
