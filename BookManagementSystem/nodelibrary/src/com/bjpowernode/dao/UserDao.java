package com.bjpowernode.dao;

import com.bjpowernode.bean.User;

import java.util.List;

public interface UserDao {
    List<User> select();

    //对此方法进行重载
    List<User> select(User user);

    void add(User user);

    void update(User user);

    void delete(int id);

    void frozen(int id);

    List<User> selectUserToLend();
}
