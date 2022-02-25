package com.mybatis.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 24 - 10:44
 **/

@Data
@ToString
public class Teacher {
    private int id;
    private String name;

    private List<Student> students;

}
