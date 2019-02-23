package cn.test.service;

import cn.test.dao.UserDao;
import cn.test.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userdao;

    @Override
    public int getTotal() {
        return userdao.getTotal();
    }

    @Override
    public User findUserById(int id) {
        return userdao.findUserById(id);
    }

    @Override
    public void addUser(User user) {
        userdao.addUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userdao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userdao.updateUser(user);
    }

    @Override
    public List<User> list(int start, int count) {
        return userdao.list(start,count);
    }





}
