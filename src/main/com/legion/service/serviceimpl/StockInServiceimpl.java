package legion.service.serviceimpl;

import legion.dao.StockInDao;
import legion.entity.StockIn;
import legion.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(readOnly = false)
public class StockInServiceimpl implements StockInService {
    @Autowired
    private StockInDao stockinDao;

    @Transactional(readOnly = false)
    public Integer addStockIn(StockIn stockin){
        return stockinDao.addStockIn(stockin);
    }

    @Transactional(readOnly = false)
    public Integer updateStockIn(StockIn stockin){
        return stockinDao.updateStockIn(stockin);
    }

    public Integer deleteStockIn(Integer id){
        return  stockinDao.deleteStockIn(id);
    }

    public StockIn listStockInById(Integer id){
        return stockinDao.listStockInById(id);
    }

    public ArrayList<StockIn> listStockIn(String state,Integer page){
        return stockinDao.listStockIn(state, page);
    }
    public Integer listallpage()
    {
        return  stockinDao.listallpage();
    }
}
