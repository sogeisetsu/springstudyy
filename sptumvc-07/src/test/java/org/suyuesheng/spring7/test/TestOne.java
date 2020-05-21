package org.suyuesheng.spring7.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.suyuesheng.spring7.mapper.UserMapper;
import org.suyuesheng.spring7.pojo.User;
import org.suyuesheng.spring7.services.UserService;
import org.suyuesheng.spring7.util.GetUUID;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestOne {
    private UserService userService;
//    @Test
//    public void testOnee(){
//        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
//        UserMapper userMapper = context.getBean("userMapper", UserMapperImpl.class);
//        System.out.println(userMapper.findAll().get(userMapper.findAll().size()-1).getDate().getClass().getName());
//
//    }

    @Test
    public void testTwo(){
        User user = new User(132, "jj", "ss", new Date());
        user.setCode(GetUUID.getUUID());
        Object o = JSON.toJSON(user);
        System.out.println(o);
        System.out.println(o);
    }

//    @Test
//    public void testSelectById(){
//        ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
//        UserMapper userMapper = context.getBean("userMapper", UserMapperImpl.class);
//        System.out.println(userMapper.findById(8));
//    }
    @Test
    public void haveATry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        System.out.println(userservice.findAll());
        User user = new User(1, "dc", "shiyan");
        System.out.println(userservice.insertUser(user));
        user.setuId(null);
        System.out.println(userservice.findById(user.getuId()));
        System.out.println(userservice.insertUser(user));
    }

    @Test
    public void testActive(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        boolean activeUser = userservice.activeUser("f36c0605c8874f6db706e07315d249341589805378717268");
        System.out.println(activeUser);
    }

    @Test
    public void testNewInsert(){
        User user = new User("root", "fdsgtd", "1446942825@qq.com");
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userservice = context.getBean("userservice", UserService.class);
        System.out.println(userservice.insertUser(user));
    }

    /**
     * list 返回所在位置
     */
    @Test
    public void testQie(){
        String msg ="http://localhost:8080/test/session";
        System.out.println(msg.indexOf("/"));
        String pattern = "/(?!/)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(msg);
        System.out.println(matcher.matches());
        ArrayList<Integer> list = new ArrayList<>();
        while (matcher.find()){
            System.out.println(matcher.group()+"|||"+matcher.start());
            list.add(matcher.start());
        }
        System.out.println(list.get(1));
        System.out.println(msg.substring(0, list.get(1)+1));
    }
}
