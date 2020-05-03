package org.suyuesheng.spring.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {
    @Test
    public void testHello(){
        /*
        * `ApplicationContext`是高级工厂的接口，
        * 能够维护不同 beans 及其依赖项的注册表。
        * 使用方法`T getBean(String name, Class requiredType)`，
        * 您可以检索 beans 的实例。*/
        //获取容器
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Beans.xml");
//        Hello hello = (Hello)classPathXmlApplicationContext.getBean("hello");
        //获取对象
        Hello hello = classPathXmlApplicationContext.getBean("hello", Hello.class);
        System.out.println(hello);
        User user = classPathXmlApplicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testTwo(){
        //获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        //获取对象
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello);
        User user = (User)applicationContext.getBean("user");
        System.out.println(user);
    }

    @Test
    public void testConstructorNoArgs(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testAlias(){
       ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Beans.xml");
        Hello hello = applicationContext.getBean("hello", Hello.class);
        //通过别名
        Hello hello2 = applicationContext.getBean("hello2", Hello.class);

        System.out.println("hello\n"+hello); //Hello{str='Hello', user=User{id=134, name='老刘', pwd='12324'}}
        System.out.println("hello2\n"+hello2); //Hello{str='Hello', user=User{id=134, name='老刘', pwd='12324'}}
    }
}
