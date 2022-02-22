package dao;

import com.mybatis.dao.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 15:01
 **/
public class UserDaoTest {
    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSession();
        List<User> result = session.getMapper(UserMapper.class).getUserList();

        result.forEach(user ->{
            System.out.println(user);
        });

        session.close();
    }

    @Test
    public void getUserById(){
        SqlSession session = MybatisUtils.getSession();
        User result = session.getMapper(UserMapper.class).getUserById(1);
        System.out.println(result);
        session.close();
    }

    @Test
    public void addUser(){
        SqlSession session = MybatisUtils.getSession();
        User user = new User("5", "Johnson", "root");
        int affectRow = session.getMapper(UserMapper.class).addUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session = MybatisUtils.getSession();
        User user = new User("5", "JohnsonTestUpdate", "root");
        int affectRow = session.getMapper(UserMapper.class).updateUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser(){
        SqlSession session = MybatisUtils.getSession();
        int affectRow = session.getMapper(UserMapper.class).deleteUser("3");

        System.out.println(affectRow);
        session.commit();
        session.close();

    }
}
