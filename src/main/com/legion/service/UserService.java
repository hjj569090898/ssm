package legion.service;
import legion.entity.User;

import java.util.ArrayList;

public interface UserService {
    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    User listUserByName(String username);

    ArrayList<User> listUser();
}
