package legion.service;
import legion.entity.ProGoods;
import legion.entity.Progress;

import java.util.ArrayList;

public interface ProgressService {
     Integer addProgress(Progress progress);

     Integer updateProgress(Progress progress);

     Integer deleteProgress(Integer id);

    Progress listProgressById(Integer id,Integer Projectid);

     ArrayList<Progress> listProgress(Integer Projectid,Integer page);


     ArrayList<ProGoods> listProgoods(Integer Projectid,Integer page);
//    public ArrayList<Project>listGoodsByType(Integer type);

    Integer  newaddgoods(ProGoods proGoods);

    Integer deleteprojectgoods(ProGoods proGoods);
}
