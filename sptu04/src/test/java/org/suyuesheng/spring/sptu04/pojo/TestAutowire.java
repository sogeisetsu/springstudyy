package org.suyuesheng.spring.sptu04.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAutowire {
    /**
     * 检查配置autowire
     */
    @Test
    public void testOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    /**
     * 测试对属性进行注解
     */
    @Test
    public void testFiledAno() {
        ApplicationContext context = new ClassPathXmlApplicationContext("PersorBeans.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }
}
