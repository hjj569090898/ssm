package legion.service.serviceimpl;

import legion.dao.UserDao;
import legion.entity.Userapply;
import legion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import legion.entity.User;

import java.util.ArrayList;

@Service
@Transactional(readOnly = false)
public class UserServiceimpl implements UserService {
    @Autowired
    private UserDao userDao;

    public Integer addUser(User user)
    {
        return userDao.addUser(user);
    }

    public Integer updateUser(User user){
        return userDao.updateUser(user);
    }

    public Integer deleteUser(Integer id){
        return userDao.deleteUser(id);
    }

    public User listUserByName(String username){
        return userDao.listUserByName(username);
    }

    public ArrayList<User> listUserByGroupid(Integer id,Integer page){
    return userDao.listUserByGroupid(id,page);
    }

    @Override
    public Integer CountUserByGroupid(Integer groupid) {
        return userDao.CountUserByGroupid(groupid);
    }

    @Override
    public ArrayList<User> listUser(Integer page) {
        return userDao.listUser(page);
    }


    @Override
    public Integer addUserapply(Userapply userapply) {
        return userDao.addUserapply(userapply);
    }

    @Override
    public Integer updateUserapply(Userapply userapply) {
        return userDao.updateUserapply(userapply);
    }

    @Override
    public Integer audiUserapply(Integer id,String state, String audidate) {
        return userDao.audiUserapply(id,state,audidate);
    }

    @Override
    public ArrayList<Userapply> listuserapply(String username) {
        return userDao.listuserapply(username);
    }

    @Override
    public Integer countuser() {
        return userDao.conutuser();
    }
}
