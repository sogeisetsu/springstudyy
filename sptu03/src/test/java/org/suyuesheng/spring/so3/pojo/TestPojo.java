package org.suyuesheng.spring.so3.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suyuesheng.spring.s03.pojo.Stusent;
import org.suyuesheng.spring.s03.pojo.User;
import org.suyuesheng.spring.s03.pojo.UserC;

public class TestPojo {

    @Test
    public void testAdress() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Stusent student = context.getBean("student", Stusent.class);
        System.out.println(student);
    }

    @Test
    public void testPNamespace() {
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBeans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
    @Test
    public void testCNameSpace(){
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBeans.xml");
        UserC user = context.getBean("userc", UserC.class);
        System.out.println(user);
    }

    /**
     * 测试单例模式和多例模式
     */
    @Test
    public void testDD(){
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBeans.xml");
        User user = context.getBean("user", User.class);
        User user1 = context.getBean("user", User.class);
        //原型模式是不相等的
        System.out.println(user==user1); //false
    }


}
