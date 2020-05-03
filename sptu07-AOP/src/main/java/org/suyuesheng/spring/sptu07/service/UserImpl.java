package org.suyuesheng.spring.sptu07.service;

public class UserImpl implements IUser {

    @Override
    public void add() {
        System.out.println("目标类UserImpl覆写的add方法");
    }

    @Override
    public void delete() {
        System.out.println("目标类UserImpl覆写的delete方法");
    }

    @Override
    public void update() {
        System.out.println("目标类UserImpl覆写的update方法");

    }

    @Override
    public void change() {
        System.out.println("目标类UserImpl覆写的change方法");

    }
}
