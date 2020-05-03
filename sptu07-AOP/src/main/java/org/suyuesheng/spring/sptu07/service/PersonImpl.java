package org.suyuesheng.spring.sptu07.service;

public class PersonImpl implements IPerson {
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void change() {
        System.out.println("change");
    }
}
