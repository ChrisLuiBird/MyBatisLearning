package com.mybatis.dao;

import com.mybatis.pojo.Teacher;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 25 - 14:33
 **/
public class dao {
    @Test
    public void getTeacherByResultPlugin(){
        SqlSession session = MyBatisUtils.getSession();
        Teacher teacherById = session.getMapper(TeacherMapper.class).getTeacherById(1);

        System.out.println(teacherById);

        session.close();
    }
    @Test
    public void getTeacherByQueryPlugin(){
        SqlSession session = MyBatisUtils.getSession();
        Teacher teacherById = session.getMapper(TeacherMapper.class).getTeacherByIdForQuery(2);

        System.out.println(teacherById);

        session.close();
    }
}
