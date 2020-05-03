package org.suyuesheng.smybatis.event.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suyuesheng.smybatis.event.mapper.UserMapper;
import org.suyuesheng.smybatis.event.pojo.User;

public class UserService extends SqlSessionDaoSupport {
    private User user;

    public void insert(){
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        user.setPwd("23423");
        user.setId(67);
        mapper.insert(user);
        mapper.deleteById(2);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
