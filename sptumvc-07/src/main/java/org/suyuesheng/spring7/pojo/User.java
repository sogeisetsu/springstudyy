package org.suyuesheng.spring7.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class User {

    private Integer uId;

    private String userName;
    private String password;
    @Value("N")
    private String status;
    @Value("001")
    private String code;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;
    public User() {
    }

    public User(Integer uId, String userName, String password) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
    }

    public User(Integer uId, String userName, String password, String status, String code) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.code = code;
    }

    public User(Integer uId, String userName, String password, Date date) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.date = date;
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
    }
}
