package legion.service;
import legion.entity.StockIn;

import java.util.ArrayList;

public interface StockInService {
    public Integer addStockIn(StockIn stockin);

    public Integer updateStockIn(StockIn stockin);

    public Integer deleteStockIn(Integer id);

    public StockIn listStockInById(Integer id);

    public ArrayList<StockIn> listStockIn(String state,Integer page);

    public Integer listallpage();
}
