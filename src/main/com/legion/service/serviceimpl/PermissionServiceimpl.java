package legion.service.serviceimpl;

import legion.dao.PermissionDao;
import legion.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class PermissionServiceimpl implements PermissionService {
    @Autowired
    private  PermissionDao permissionDao;
    public List listPermission(String username)
    {
        return permissionDao.listpermission(username);
    }

    @Override
    public List listGroupPermission(String username) {
        return permissionDao.listgrouppermission(username);
    }



}
