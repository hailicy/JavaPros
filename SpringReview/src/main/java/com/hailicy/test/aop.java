package com.hailicy.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class aop {

    @Before(value = "execution(* com.hailicy.test.Person.*(..))")
    public void qianzhi(){
        System.out.println("前置：准备睡觉！");
    }

    @After(value = "execution(* com.hailicy.test.Person.*(..))")
    public void houzhi(){
        System.out.println("后置：睡着！");
    }

    @AfterThrowing(value = "execution(* com.hailicy.test.Person.*(..))")
    public void yichang(){
        System.out.println("异常！");
    }

    @Around(value = "execution(* com.hailicy.test.Person.*(..))")
    public void huanrao(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前！");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后！");
    }

    @AfterReturning(value = "execution(* com.hailicy.test.Person.*(..))")
    public void zuizhong(){
        System.out.println("最终：到天亮");
    }
}
