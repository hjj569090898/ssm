package legion.service;
import legion.entity.Finance;

import java.util.ArrayList;

public interface FinanceService {
    public Integer addFinance(Finance finance);

    public Integer updateFinance(Finance finance);

    public Integer deleteFinance(Integer id);

    public Finance listFinanceById(Integer id);

    public ArrayList<Finance> listFinance(String type, Integer page);

    public Integer listallpage();
}
