package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 14:52
 **/
public interface UserDao {
    @Select("select * from user")
    @Results(id = "UserMap", value = {
            @Result(column = "pwd", property = "password")
    })
    public List<User> getUserList();

    @Select("select * from user where id = #{id}")
    @ResultMap("UserMap")
    public User getUserById(@Param("id") int id);

    @Insert("insert into user(id, name, pwd) values (#{id}, #{name}, #{pwd})")
    public int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    public int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    public int deleteUser(@Param("id") int id);
}
