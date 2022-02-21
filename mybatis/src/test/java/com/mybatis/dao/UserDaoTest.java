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
}
