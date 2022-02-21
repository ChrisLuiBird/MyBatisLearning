package com.mybatis.dao;

import com.mybatis.pojo.User;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 15:01
 **/
public class UserDaoTest {
    @Test
    public void test(){
        SqlSession session = MyBatisUtils.getSession();
        List<User> result = session.getMapper(UserDao.class).getUserList();

        result.forEach(user ->{
            System.out.println(user);
        });

        session.close();
    }

    @Test
    public void getUserById(){
        SqlSession session = MyBatisUtils.getSession();
        User result = session.getMapper(UserDao.class).getUserById(1);
        System.out.println(result);
        session.close();
    }

    @Test
    public void addUser(){
        SqlSession session = MyBatisUtils.getSession();
        User user = new User("5", "Johnson", "root");
        int affectRow = session.getMapper(UserDao.class).addUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session = MyBatisUtils.getSession();
        User user = new User("5", "JohnsonTestUpdate", "root");
        int affectRow = session.getMapper(UserDao.class).updateUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser(){
        SqlSession session = MyBatisUtils.getSession();
        int affectRow = session.getMapper(UserDao.class).deleteUser("3");

        System.out.println(affectRow);
        session.commit();
        session.close();

    }
}
