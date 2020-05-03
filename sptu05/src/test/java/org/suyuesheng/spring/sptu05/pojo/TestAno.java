package org.suyuesheng.spring.sptu05.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAno {
    @Test
    public void testAno() {
        ApplicationContext context = new ClassPathXmlApplicationContext("AnoBeans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
