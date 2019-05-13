package legion.dao;

import legion.entity.GoodsApply;
import legion.entity.ProGoods;
import legion.entity.Project;
import legion.entity.ProjectCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProjectDao {
    Integer addProject(Project project);

    Integer updateProject(Project project);

    Integer deleteProject(@Param("id") Integer id);

    Project listProjectById(@Param("id") Integer id);

    ArrayList<Project> listProject(@Param("page") Integer page);

    ProjectCount listProjectCount(@Param("projectid") Integer projectid);

    List listimageurl(@Param("projectid") Integer projectid);

    Integer addimageurl(@Param("projectid") Integer projectid,@Param("imageurl") String imageurl);

    Integer addprojectgoodsplan(ProGoods proGoods);

    Integer addprojectgoodsapply(GoodsApply goodsApply);

    Integer updategoodsapply(GoodsApply goodsApply);

    Integer updateprogressgoods(ProGoods proGoods);

    ProGoods findprogoods(@Param("id") Integer id);
}
