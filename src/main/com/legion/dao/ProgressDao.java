package legion.dao;

import legion.entity.ProGoods;
import legion.entity.Progress;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public interface ProgressDao {
    Integer addProgress(Progress progress);

    Integer updateProgress(Progress progress);

    Integer deleteProgress(@Param("id") Integer id);

    Progress listProgressById(@Param("id") Integer id,@Param("projectid") Integer projectid);

    ArrayList<Progress> listProgress(@Param("projectid") Integer projectid,@Param("page") Integer page);

    //汇总统计

    ArrayList<ProGoods> listProgoods(@Param("projectid") Integer projectid,@Param("page") Integer page);

    Integer newaddgoods (ProGoods proGoods);

    Integer deleteprojectgoods(ProGoods proGoods);

}
