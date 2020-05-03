package org.suyuesheng.spring.sptu07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suyuesheng.spring.sptu07.service.*;

public class testAop {
    @Test
    public void testAopOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //动态代理的是接口
        IUser user = context.getBean("user", IUser.class);
        user.add();
    }

    /**
     * 测试自定义Aop
     */
    @Test
    public void testAopDiy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //获取对象，因为aop，动态代理的是接口返回值类型要写接口
        IPerson person = context.getBean("person", IPerson.class);
        person.add();
    }

    @Test
    public void testAnnoLog() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        IPhone phone = context.getBean("phone", IPhone.class);
        phone.add();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        IUser update = phone.update();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        update.add();
        System.out.println(update);
    }
}













