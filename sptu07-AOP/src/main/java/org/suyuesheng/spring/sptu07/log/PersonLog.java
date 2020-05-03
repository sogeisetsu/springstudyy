package org.suyuesheng.spring.sptu07.log;

public class PersonLog {
    public void methodBefore(){
        System.out.println("方法执行之前");

    }
    public void afterMethod(){
        System.out.println("方法执行之后");
    }
}
