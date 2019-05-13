package legion.service.serviceimpl;

import legion.dao.ProjectDao;
import legion.entity.GoodsApply;
import legion.entity.ProGoods;
import legion.entity.Project;
import legion.entity.ProjectCount;
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

    @Override
    public Integer addProject(Project project) {
        return projectdao.addProject(project);
    }

    @Override
    public Integer updateProject(Project project) {
        return projectdao.updateProject(project);
    }

    @Override
    public Integer deleteProject(Integer id) {
        return projectdao.deleteProject(id);
    }

    @Override
    public Project listProjectById(Integer Projectid) {
        return projectdao.listProjectById(Projectid);
    }

    @Override
    public ArrayList<Project> listProject(Integer page) {
        return projectdao.listProject(page);
    }

    @Override
    public ProjectCount listProjectCount(Integer projectid) {
        return projectdao.listProjectCount(projectid);
    }

    @Override
    public List listimageurl(Integer projectid) {
        return projectdao.listimageurl(projectid);
    }

    @Override
    public Integer addimageurl(Integer projectid, String imageurl) {
        return projectdao.addimageurl(projectid,imageurl);
    }

    @Override
    public Integer addprojectgoods(ProGoods proGoods) {
        return projectdao.addprojectgoodsplan(proGoods);
    }

    @Override
    public Integer addprojectapply(GoodsApply goodsApply) {
        return projectdao.addprojectgoodsapply(goodsApply);
    }

    @Override
    public Integer updategoodsapply(GoodsApply goodsApply) {
        return projectdao.updategoodsapply(goodsApply);
    }

    @Override
    public Integer updateprogressgoods(ProGoods proGoods) {
        return projectdao.updateprogressgoods(proGoods);
    }

    @Override
    public ProGoods findprogoods(Integer id) {
        return projectdao.findprogoods(id);
    }
}
