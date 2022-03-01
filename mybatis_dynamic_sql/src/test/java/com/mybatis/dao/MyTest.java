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
}
