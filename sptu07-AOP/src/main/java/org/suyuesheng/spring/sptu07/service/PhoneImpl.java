package org.suyuesheng.spring.sptu07.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PhoneImpl implements IPhone {
    @Override
    public void add() {
        System.out.println("add方法被执行");
    }

    @Override
    public void delete() {

    }

    @Override
    public IUser update() {
        System.out.println("update方法被执行");
        return new ClassPathXmlApplicationContext("Beans.xml").getBean("user", IUser.class);
    }

    @Override
    public void change() {

    }
}
