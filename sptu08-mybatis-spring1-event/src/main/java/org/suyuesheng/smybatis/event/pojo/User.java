package org.suyuesheng.smybatis.event.pojo;

import org.springframework.beans.factory.annotation.Value;

public class User {
    private int id;
    private String name;
    private String pwd;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    @Value("17")
    public void setId(int id) {
        this.id = id;
    }
    @Value("老刘")
    public void setName(String name) {
        this.name = name;
    }
    @Value("121432543")
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
