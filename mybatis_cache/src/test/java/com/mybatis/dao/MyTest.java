package com.mybatis.dao;

import com.mybatis.pojo.User;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author LUIKITFUNG
 * @create 2022 - 03 - 03 - 14:22
 **/
public class MyTest {

//    一级缓存测试
    @Test
    public void getUserById(){
        SqlSession session = MyBatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);
        System.out.println("=============启用一级缓存不会再执行SQL==============");
        System.out.println(user);
        session.close();
    }

    //二级缓存
    @Test
    public void test(){
        SqlSession session = MyBatisUtils.getSession();
        SqlSession session2 = MyBatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        session.close();

        UserMapper mapper2 = session2.getMapper(UserMapper.class);
        User user2 = mapper2.getUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);
        session.close();


    }

}
