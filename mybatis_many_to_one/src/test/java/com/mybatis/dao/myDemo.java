package com.mybatis.dao;

import com.mybatis.pojo.Student;
import com.mybatis.pojo.Teacher;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 24 - 10:55
 **/
public class myDemo {

    @Test
    public void getTeacherTest(){
        SqlSession session = MyBatisUtils.getSession();

        Teacher teacher = session.getMapper(TeacherMapper.class).getTeacherById(1);

        System.out.println(teacher);

        session.close();
    }

    @Test
    public void manyToOne(){
        SqlSession session = MyBatisUtils.getSession();

        List<Student> students = session.getMapper(StudentMapper.class).getStudents();

        students.forEach(s ->{
            System.out.println(s);
        });


        session.close();
    }

//    结果嵌套
    @Test
    public void manyToOne2(){
        SqlSession session = MyBatisUtils.getSession();

        List<Student> students = session.getMapper(StudentMapper.class).getStudentsForResult();

        students.forEach(s ->{
            System.out.println(s);
        });


        session.close();
    }
}
