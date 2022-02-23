package com.mybatisConfig.dao;

import com.mybatisConfig.pojo.User2;

import java.util.List;
import java.util.Map;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 14:52
 **/
public interface User2Mapper {
    public List<User2> getUserList();
    public User2 getUserById(int id);
    public int addUser(User2 user);
    public int updateUser(User2 user);
    public int deleteUser(String id);

    public List<User2> getUserListByPage(Map<String, Integer> pageMap);
}
