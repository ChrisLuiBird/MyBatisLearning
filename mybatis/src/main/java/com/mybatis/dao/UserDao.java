package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 14:52
 **/
public interface UserDao {
    public List<User> getUserList();
}
