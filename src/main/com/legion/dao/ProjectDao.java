package legion.dao;

import legion.entity.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProjectDao {
    Integer addProject(Project project);

    Integer updateProject(Project project);

    Integer deleteProject(@Param("id") Integer id);

    Project listProjectById(@Param("id") Integer id);

    ArrayList<Project> listProject();


}
