package com.mybatisConfig.dao;

import com.mybatis.dao.UserDao;
import com.mybatis.pojo.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 15:01
 **/
public class UserDaoTest {
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        List<User> result = session.getMapper(UserDao.class).getUserList();

        result.forEach(user ->{
            System.out.println(user);
        });

        session.close();
    }

    @Test
    public void getUserById(){
        SqlSession session = MybatisUtils.getSession();
        User result = session.getMapper(UserDao.class).getUserById(1);
        System.out.println(result);
        session.close();
    }

    @Test
    public void addUser(){
        SqlSession session = MybatisUtils.getSession();
        User user = new User("5", "Johnson", "root");
        int affectRow = session.getMapper(UserDao.class).addUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session = MybatisUtils.getSession();
        User user = new User("5", "JohnsonTestUpdate", "root");
        int affectRow = session.getMapper(UserDao.class).updateUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser(){
        SqlSession session = MybatisUtils.getSession();
        int affectRow = session.getMapper(UserDao.class).deleteUser("3");

        System.out.println(affectRow);
        session.commit();
        session.close();

    }


    @Test
    public void addUserByMap(){
        SqlSession session = MybatisUtils.getSession();
        Map<String, Object> map = new HashMap<>();
        map.put("userId", 6);
        map.put("userName","testMap");
        map.put("passWord","pwd");

        int affectMap = session.getMapper(UserDao.class).addUserByMap(map);
        System.out.println(affectMap);
        session.commit();
        session.close();
    }
}
