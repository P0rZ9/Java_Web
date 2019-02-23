package cn.test.service;

import cn.test.entity.User;

import java.util.List;

public interface UserService {
    int getTotal();
    User findUserById(int id);
    void addUser(User user);
    void deleteUserById(int id);
    void updateUser(User user);

    List<User> list(int start, int count);





}
