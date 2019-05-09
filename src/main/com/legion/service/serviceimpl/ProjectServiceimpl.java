package legion.service.serviceimpl;

import legion.dao.ProjectDao;
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
}
