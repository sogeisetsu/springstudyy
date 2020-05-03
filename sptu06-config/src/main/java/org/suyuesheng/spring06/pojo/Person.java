package org.suyuesheng.spring06.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Perpp")
public class Person {
    @Value("12")
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
