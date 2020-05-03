package org.suyuesheng.spring.pojo;

public class Hello {
    private String str;
    private User user;
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                ", user=" + user +
                '}';
    }
}
