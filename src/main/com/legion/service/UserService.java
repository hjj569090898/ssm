package legion.service;
import legion.entity.User;
import legion.entity.Userapply;

import java.util.ArrayList;

public interface UserService {
    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    Integer countuser();

    User listUserByName(String username);

    ArrayList<User> listUserByGroupid(Integer id,Integer page);

    Integer CountUserByGroupid(Integer groupid);

    ArrayList<User> listUser(Integer page);

    Integer addUserapply(Userapply userapply);

    Integer updateUserapply(Userapply userapply);

    Integer audiUserapply(Integer id,String state,String audidate);

    ArrayList<Userapply> listuserapply(String username);
}
