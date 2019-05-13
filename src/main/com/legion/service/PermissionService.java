package legion.service;

import legion.entity.Permission;

import java.util.ArrayList;
import java.util.List;

public interface PermissionService {

     List listPermission(String username);

    List listGroupPermission(String username);

    ArrayList<Permission> userper(String username);

    ArrayList<Permission> usergroupper(String username);

    Integer addpermission(String permission,Integer userid);

    Integer deletepermission(Integer userid);
}
