package legion.dao;

import legion.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserDao {
    int addUser(User user);

    User listUserByName(@Param("username") String username);

    Integer updateUser(User user);

    Integer deleteUser(@Param("id") Integer id);

    ArrayList<User> listUser();
}
