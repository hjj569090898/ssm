package legion.dao;

import legion.entity.User;
import legion.entity.Userapply;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserDao {
    int addUser(User user);

    User listUserByName(@Param("username") String username);

    Integer updateUser(User user);

    Integer conutuser();

    Integer deleteUser(@Param("id") Integer id);

    ArrayList<User> listUserByGroupid(@Param("groupid") Integer id,@Param("page") Integer page);

    Integer CountUserByGroupid(@Param("groupid") Integer groupid);

    ArrayList<User> listUser(@Param("page") Integer page);

    Integer addUserapply(Userapply userapply);

    Integer updateUserapply(Userapply userapply);

    ArrayList<Userapply> listuserapply(@Param("username") String username);

    Integer audiUserapply(@Param("id") Integer id,@Param("state") String state,@Param("audidate") String audidate);
}
