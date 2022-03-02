package com.mybatis.dao;

import com.mybatis.pojo.Blog;
import com.mybatis.utils.IDUtils;
import com.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author LUIKITFUNG
 * @create 2022 - 03 - 01 - 14:18
 **/
public class MyTest {
    @Test
    public void addBlog(){
        SqlSession session = MyBatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setAuthor("chris");
        blog.setTitle("T1");
        blog.setCreateTime(new Date());
        blog.setViews(11);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("T2");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("T3");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("T4");
        mapper.addBlog(blog);

        session.close();

    }

    @Test
    public void getBlogs(){
        SqlSession session = MyBatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map<String, Object> queryMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("T");
        queryMap.put("title",list );
        queryMap.put("author","c");


        List<Blog> result = mapper.getBlogs(queryMap);
        result.forEach(blog -> {
            System.out.println(blog);
        });
        session.close();
    }

    @Test
    public void geBlogsByChoose(){
        SqlSession session = MyBatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Map<String, Object> queryMap = new HashMap<>();
//        queryMap.put("title","T1");
//        queryMap.put("author","c");
        queryMap.put("views","3");
        List<Blog> result = mapper.getBlogsByChoose(queryMap);
        result.forEach(blog -> {
            System.out.println(blog);
        });
        session.close();
    }

    @Test
    public void updateBlog(){
        SqlSession session = MyBatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId("920b2e580825411b8ac96c2c249aa926");
//        blog.setTitle("H3");
        blog.setAuthor("cryin2");

        int resultRow = mapper.updateBlog(blog);
        System.out.println(resultRow);
        session.close();
    }

    @Test
    public void queryByForeach(){
        SqlSession session = MyBatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        List<String> ids = new ArrayList<>();
        ids.add("1a284b03112f422f9010fdfe8ccd320e");
        ids.add("624c37d475ad49f382bb8210518e3e11");

        List<Blog> blogs = mapper.queryByForeach(ids);

        blogs.forEach(b ->{
            System.out.println(b);
        });

        session.close();
    }
}
