package mvc.xin.controller.json.mapper.test;

import mvc.xin.controller.json.mapper.UserMapper;
import mvc.xin.controller.json.pojo.User;
import mvc.xin.controller.json.services.UserServicesImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestMapper {
    @Test
    public void testOne(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeansMvc.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        System.out.println("userMapper.findAll() = " + userMapper.findAll());
    }
    @Test
    public void testT(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeansMvc.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = context.getBean("user", User.class);
//        user.setBirthday(new Date());
        System.out.println("userMapper.insertUser(user) = " + userMapper.insertUser(user));
    }

    @Test
    public void testDate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeansMvc.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        System.out.println("userMapper.findDate(\"Tom\") = " + userMapper.findDate("Tom"));
    }
    @Test
    public void testUserServices(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeansMvc.xml");
        UserServicesImpl userServicesImpl = context.getBean("userServicesImpl", UserServicesImpl.class);
        User user = context.getBean("user", User.class);
        System.out.println("userServicesImpl.insertUser(user) = " + userServicesImpl.insertUser(user));
    }

    @Test
    public void testDateLong(){
        System.out.println("new Date().getTime() = " + String.valueOf(new Date().getTime()).toCharArray().length);
    }

}
