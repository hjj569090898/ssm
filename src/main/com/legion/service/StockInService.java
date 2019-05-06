package legion.service;
import legion.entity.StockIn;

import java.util.ArrayList;

public interface StockInService {
     Integer addStockIn(StockIn stockin);

     Integer updateStockIn(StockIn stockin);

     Integer deleteStockIn(Integer id);

     StockIn listStockInById(Integer id);

     ArrayList<StockIn> listStockIn(String state,Integer page);

     Integer listallpage();
}
