package legion.dao;
import legion.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PermissionDao {
    List listpermission(@Param("username") String username);//根据用户名获得用户的权限

    List listgrouppermission(@Param("username") String username);//根据用户名获得用户组的信息

    ArrayList<Permission> userper(@Param("username") String username);

    ArrayList<Permission> usergroupper(@Param("username") String username);

}
