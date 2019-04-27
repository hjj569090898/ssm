package legion.service.serviceimpl;

import legion.dao.StockOutDao;
import legion.entity.StockOut;
import legion.service.StockOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class StockOutServiceimpl implements StockOutService {

    @Autowired
    private StockOutDao stockoutDao;

    @Transactional(readOnly = false)
    public Integer addStockOut(StockOut stockOut){
        return stockoutDao.addStockOut(stockOut);
    }

    @Transactional(readOnly = false)
    public Integer updateStockOut(StockOut stockOut){
        return stockoutDao.updateStockOut(stockOut);
    }

    public Integer deleteStockOut(Integer id){
        return  stockoutDao.deleteStockOut(id);
    }

    public StockOut listStockOutById(Integer id){
        return stockoutDao.listStockOutById(id);
    }

    public ArrayList<StockOut> listStockOut(String state,Integer page){
        return stockoutDao.listStockOut(state, page);
    }
    public Integer listallpage(String state)
    {
        return  stockoutDao.listallpage(state);
    }
}
