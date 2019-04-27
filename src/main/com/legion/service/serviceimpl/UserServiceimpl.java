package legion.service.serviceimpl;

import legion.dao.UserDao;
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

    public ArrayList<User> listUser(){
    return userDao.listUser();
    }
}
