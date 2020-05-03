package org.suyuesheng.spring.sptu07.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BLog implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"."+method.getName());
    }
}
