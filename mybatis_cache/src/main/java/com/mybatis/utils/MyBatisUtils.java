package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 14:48
 **/
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream ip = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }
}
