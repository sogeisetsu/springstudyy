package org.suyuesheng.spring.sptu07.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class ALog implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"."+method.getName());
        if(returnValue!=null){
            System.out.println(returnValue.getClass().getName());
        }
    }
}
