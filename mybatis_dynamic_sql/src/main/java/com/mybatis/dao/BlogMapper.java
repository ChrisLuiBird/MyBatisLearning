package com.mybatis.dao;

import com.mybatis.pojo.Blog;
import java.util.List;
import java.util.Map;

/**
 * @author LUIKITFUNG
 * @create 2022 - 03 - 01 - 14:05
 **/
@SuppressWarnings("all") //抑制警告
public interface BlogMapper {
    public int addBlog(Blog blog);
    public List<Blog> getBlogs(Map<String, Object> map);
}
