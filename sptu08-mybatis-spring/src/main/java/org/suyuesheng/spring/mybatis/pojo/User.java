package org.suyuesheng.spring.mybatis.pojo;

import org.springframework.beans.factory.annotation.Value;

public class User {
    private int id;
    private String name;
    private String pwd;

    public User() {
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
