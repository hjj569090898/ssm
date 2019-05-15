package legion.service;
import legion.entity.Finance;

import java.util.ArrayList;

public interface FinanceService {
     Integer addFinance(Finance finance);

     Integer updateFinance(Finance finance);

     Integer deleteFinance(Integer id);

     Finance listFinanceById(Integer id);

     ArrayList<Finance> listFinance(String type, Integer page);

     Integer listallpage(String type);
}
