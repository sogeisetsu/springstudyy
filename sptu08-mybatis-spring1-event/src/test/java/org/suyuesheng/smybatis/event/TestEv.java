package org.suyuesheng.smybatis.event;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suyuesheng.smybatis.event.mapper.UserMapper;
import org.suyuesheng.smybatis.event.pojo.User;
import org.suyuesheng.smybatis.event.service.UserService;

public class TestEv {
    @Test
    public void testOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserMapper userMapper = context.getBean("UserMapper", UserMapper.class);
        System.out.println(userMapper.findAll());
        System.out.println(userMapper.findById(2));
        User user = context.getBean("user", User.class);
        user.setId(66);
        user.setName("老张");
        user.setPwd("dwqf2315");
        if(userMapper.findById(user.getId()).size()==0){
            userMapper.insert(user);
        }
    }

    @Test
    public void testTwo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.insert();

    }
}
