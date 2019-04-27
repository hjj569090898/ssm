package legion.service;

import java.util.List;

public interface PermissionService {

     List listPermission(String username);

    List listGroupPermission(String username);
}
