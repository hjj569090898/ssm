package legion.service.serviceimpl;

import legion.dao.ProgressDao;
import legion.entity.Progress;
import legion.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional(readOnly = false)
public class ProgressServiceimpl implements ProgressService {

    @Autowired
    private ProgressDao progressDao;


    @Override
    public Integer addProgress(Progress progress) {
        return progressDao.addProgress(progress);
    }

    @Override
    public Integer updateProgress(Progress progress) {
        return progressDao.updateProgress(progress);
    }

    @Override
    public Integer deleteProgress(Integer id) {
        return progressDao.deleteProgress(id);
    }

    @Override
    public Progress listProgressById(Integer id,Integer Projectid) {
        return progressDao.listProgressById(id,Projectid);
    }

    @Override
    public ArrayList<Progress> listProgress(Integer Projectid,Integer page) {
        return progressDao.listProgress(Projectid, page);
    }
}
