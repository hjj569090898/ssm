package legion.service.serviceimpl;

import legion.dao.FinanceDao;
import legion.entity.Finance;
import legion.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(readOnly = false)
public class FinanceServiceimpl implements FinanceService {
    @Autowired
    private FinanceDao financeDao;
    public Integer addFinance(Finance stockin){
        return financeDao.addFinance(stockin);
    }

    public Integer updateFinance(Finance stockin){
        return financeDao.updateFinance(stockin);
    }

    public Integer deleteFinance(Integer id){
        return  financeDao.deleteFinance(id);
    }

    public Finance listFinanceById(Integer id){
        return financeDao.listFinanceByID(id);
    }

    public ArrayList<Finance> listFinance(String type,Integer page){
        return financeDao.listFinance(type, page);
    }
    public Integer listallpage(String type)
    {
        return  financeDao.listallpage(type);
    }
}
