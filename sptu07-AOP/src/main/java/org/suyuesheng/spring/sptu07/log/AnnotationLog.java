package org.suyuesheng.spring.sptu07.log;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//使用 @Aspect 让该类变成一个切面
@Aspect
public class AnnotationLog {

    @Before("execution(* org.suyuesheng.spring.sptu07.service.PhoneImpl.*(..))")
    public void before(){
        System.out.println("前置增强");
    }
    @After("execution(* org.suyuesheng.spring.sptu07.service.PhoneImpl.*(..))")
    public void after(){
        System.out.println("后置增强");
    }
    @Around("execution(* org.suyuesheng.spring.sptu07.service.PhoneImpl.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        System.out.println("环绕前");
        Object proceed = point.proceed();
        System.out.println("环绕后");
        System.out.println(point.getSignature().toString());
        return proceed;

    }
    @AfterReturning("execution(* org.suyuesheng.spring.sptu07.service.PhoneImpl.*(..))")
    public void afterReturn(){
        System.out.println("返回增强");
    }
}
