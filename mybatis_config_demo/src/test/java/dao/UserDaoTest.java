package dao;

import com.mybatisConfig.utils.MyBatisUtils;
import com.mybatisConfig.dao.User2Mapper;
import com.mybatisConfig.pojo.User2;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 21 - 15:01
 **/
public class UserDaoTest {
    @Test
    public void test(){
        SqlSession session = MyBatisUtils.getSession();
        List<User2> result = session.getMapper(User2Mapper.class).getUserList();

        result.forEach(user ->{
            System.out.println(user);
        });

        session.close();
    }

    @Test
    public void getUserById(){
        SqlSession session = MyBatisUtils.getSession();
        User2 result = session.getMapper(User2Mapper.class).getUserById(1);
        System.out.println(result);
        session.close();
    }

    @Test
    public void addUser(){
        SqlSession session = MyBatisUtils.getSession();
        User2 user = new User2("5", "Johnson", "root");
        int affectRow = session.getMapper(User2Mapper.class).addUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void updateUser(){
        SqlSession session = MyBatisUtils.getSession();
        User2 user = new User2("5", "JohnsonTestUpdate", "root");
        int affectRow = session.getMapper(User2Mapper.class).updateUser(user);
        System.out.println(affectRow);
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser(){
        SqlSession session = MyBatisUtils.getSession();
        int affectRow = session.getMapper(User2Mapper.class).deleteUser("3");

        System.out.println(affectRow);
        session.commit();
        session.close();

    }

    @Test
    public void getUserByPage(){
        SqlSession session = MyBatisUtils.getSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);

        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("start", 0);
        pageMap.put("size", 2);

        List<User2> userListByPage = mapper.getUserListByPage(pageMap);
        userListByPage.forEach(user ->{
            System.out.println(user);
        });

        session.close();
    }
}
