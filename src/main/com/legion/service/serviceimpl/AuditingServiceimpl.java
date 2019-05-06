package legion.service.serviceimpl;

import legion.dao.AuditingDao;
import legion.entity.Auditing;

import legion.service.AuditingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(readOnly = false)
public class AuditingServiceimpl implements AuditingService {
    @Autowired
    private AuditingDao auditingDao;
    @Override
    public Integer add(Auditing auditing) {
        return auditingDao.add(auditing);
    }

    @Override
    public Integer update(String admin,String advice,String state,String adate,Integer id) {
        return auditingDao.update(admin, advice, state, adate,id);
    }

    @Override
    public ArrayList<Auditing> listAuditing(String type, String state, Integer page) {
        return auditingDao.ListAuditing(type,state,page);
    }

    @Override
    public Auditing QueryAuditing(Integer id) {
        return auditingDao.QueryAuditing(id);
    }
}
