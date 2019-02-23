package cn.test.dao;

import cn.test.entity.User;

import java.util.List;

public interface UserDao {
    int getTotal();
    User findUserById(int id);
    void addUser(User user);
    void deleteUserById(int id);
    void updateUser(User user);

    List<User> list(int start, int count);
}
