package org.suyuesheng.spring06.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.suyuesheng.spring06.config.AppConfig;

public class TestConfig {
    @Test
    public void testOne() {
        //获取注解的spring容器的context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser);
        //Perpp的来源是@Component("Perpp")
        Person person = context.getBean("Perpp", Person.class);
        System.out.println(person);
    }
}
