package legion.service.serviceimpl;

import legion.dao.ProjectDao;
import legion.entity.Project;
import legion.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = false)
public class ProjectServiceimpl implements ProjectService {
    @Autowired
    private ProjectDao projectdao;

    @Transactional(readOnly = false)
    public Integer addGoods(Goods goods){
        return goodsDao.addGoods(goods);
    }

    @Transactional(readOnly = false)
    public Integer updateGoods(Goods goods){
        return goodsDao.updateGoods(goods);
    }

    public Integer deleteGoods(Integer id){
        return  goodsDao.deleteGoods(id);
    }

    public Goods listGoodsById(Integer Goodsid){
        return goodsDao.listGoodsById(Goodsid);
    }

    public ArrayList<Goods> listGoods(){
        return goodsDao.listGoods();
    }

    public ArrayList<Goods> listGoodsByType(Integer type)
    {
        return goodsDao.listGoodsByType(type);
    }
}
