package org.suyuesheng.spring.sptu05.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于<bean id="user" class="org.suyuesheng.spring.sptu05.pojo.User"/>
@Component
@Scope(value = "singleton")
public class User {
    @Value("12")
    private int age;
    @Value("老刘")
    private String name;

    public User() {
    }

    public int getAge() {
        return age;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
