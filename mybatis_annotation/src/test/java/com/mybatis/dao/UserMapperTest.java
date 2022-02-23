package com.mybatis.dao;

import com.mybatis.pojo.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 23 - 15:44
 **/
public class UserMapperTest {

    @Test
    public void getUserList(){
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(user ->{
            System.out.println(user);
        });
        session.close();
    }

    @Test
    public void getUserById(){
        SqlSession session = MybatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.getUserById(1);

        System.out.println(user);

        session.close();
    }
    @Test
    public void addUser(){
        SqlSession session = MybatisUtils.getSession();
        int row = session.getMapper(UserDao.class).addUser(new User("7","Annotation test add", "root"));
        System.out.println(row);
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session = MybatisUtils.getSession();
        int row = session.getMapper(UserDao.class).updateUser(new User("7","Annotation test add2", "root changed"));
        System.out.println(row);
        session.close();
    }

    @Test
    public void delUser(){
        SqlSession session = MybatisUtils.getSession();

        int row = session.getMapper(UserDao.class).deleteUser(7);
        System.out.println(row);
        session.close();
    }
}
