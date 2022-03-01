package com.mybatis.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author LUIKITFUNG
 * @create 2022 - 03 - 01 - 14:02
 **/
@Data
@SuppressWarnings("all")
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime; //字段名不抑制, 用经典_ 数据库名 变成 java 驼峰
    private int views;
}
