package legion.service;
import legion.entity.Project;

import java.util.ArrayList;
import java.util.List;

public interface Project {
    public Integer addProject(Project project);

    public Integer updateProject(Project project);

    public Integer deleteProject(Integer id);

    public Project listProjectById(Integer Projectid);

    public ArrayList<Project> listProject();

//    public ArrayList<Project>listGoodsByType(Integer type);
}
