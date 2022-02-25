package com.mybatis.dao;

import com.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student")
    public List<Student> getStudentList();

    public List<Student> getStudents();
    public List<Student> getStudentsForResult();
}
