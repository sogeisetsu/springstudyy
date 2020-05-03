package org.suyuesheng.spring.mybatis;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.suyuesheng.spring.mybatis.mapper.UserMapper;
import org.suyuesheng.spring.mybatis.mapper.UserMapperImpl;
import org.suyuesheng.spring.mybatis.mapper.UserMapperImpl2;

public class TestMybatis {
    @Test
    public void testOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        SqlSessionTemplate sqlsession = context.getBean("sqlsession", SqlSessionTemplate.class);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        System.out.println(mapper.findAll());
//        sqlsession.close();
    }
    @Test
    public void testTwo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        SqlSessionTemplate sqlsession = context.getBean("sqlsession", SqlSessionTemplate.class);
//        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
//        System.out.println(mapper.findAll());
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        userMapper.findAll();
    }
    @Test
    public void testT(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserMapperImpl userMapper1 = context.getBean("userMapper1", UserMapperImpl.class);
        System.out.println(userMapper1.findAll());
    }
    @Test
    public void testBySqlDaoSupport(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserMapperImpl2 userMapperImpl2 = context.getBean("userMapperImpl2", UserMapperImpl2.class);
        System.out.println(userMapperImpl2.findAll());
    }
}
