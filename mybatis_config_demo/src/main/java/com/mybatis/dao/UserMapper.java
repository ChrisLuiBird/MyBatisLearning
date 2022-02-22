package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 14:52
 **/
public interface UserMapper {
    public List<User> getUserList();
    public User getUserById(int id);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(String id);
}
