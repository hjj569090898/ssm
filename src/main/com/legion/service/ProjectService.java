package legion.service;
import legion.entity.Project;
import legion.entity.ProjectCount;

import java.util.ArrayList;
import java.util.List;

public interface ProjectService {
     Integer addProject(Project project);

     Integer updateProject(Project project);

     Integer deleteProject(Integer id);

     Project listProjectById(Integer Projectid);

     ArrayList<Project> listProject(Integer page);

     ProjectCount listProjectCount(Integer projectid);

     List listimageurl(Integer projectid);

     Integer addimageurl(Integer projectid,String imageurl);

//    public ArrayList<Project>listGoodsByType(Integer type);
}
