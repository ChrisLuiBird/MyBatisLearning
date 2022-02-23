package com.mybatisConfig.pojo;

/**
 * @author LUIKITFUNG
 * @create 2022 - 02 - 18 - 16:45
 **/
public class User2 {
    private String id;
    private String name;
//    与数据库不一致,resultMap demoi
    private String password;

    public User2() {
    }

    public User2(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
