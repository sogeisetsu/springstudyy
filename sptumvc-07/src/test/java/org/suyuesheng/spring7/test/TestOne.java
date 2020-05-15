package org.suyuesheng.spring7.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suyuesheng.spring7.mapper.UserMapper;
import org.suyuesheng.spring7.mapper.UserMapperImpl;
import org.suyuesheng.spring7.pojo.User;
import org.suyuesheng.spring7.services.UserService;
import org.suyuesheng.spring7.util.GetUUID;

import java.util.Date;

public class TestOne {
    @Test
    public void testOnee(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapperImpl.class);
        System.out.println(userMapper.findAll().get(userMapper.findAll().size()-1).getDate().getClass().getName());

    }

    @Test
    public void testTwo(){
        User user = new User(132, "jj", "ss", new Date());
        user.setCode(GetUUID.getUUID());
        Object o = JSON.toJSON(user);
        System.out.println(o);
        System.out.println(o);
    }

    @Test
    public void testSelectById(){
        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapperImpl.class);
        System.out.println(userMapper.findById(8));
    }
    @Test
    public void haveATry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        System.out.println(userservice.findAll());
        User user = new User(1, "dc", "shiyan");
        System.out.println(userservice.insertUser(user));
        user.setuId(null);
        UserMapper userMapper = context.getBean("userMapper", UserMapperImpl.class);
        System.out.println(userservice.findById(user.getuId()));
        System.out.println(userservice.insertUser(user));
    }
}
