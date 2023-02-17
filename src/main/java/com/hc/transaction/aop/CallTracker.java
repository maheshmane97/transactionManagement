package com.hc.transaction.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracker {

    //Advice method or advice should be written in the aop
    //if we want to Log to every execution of method no need to write in each method we need to do aop
    //Proxy is not only for calling your business logic it also runs the advice before that
    @Pointcut("within(com..service.* || com..repository.*)")
    public void logMethodPointCut(){

    }

//    @Before("logMethodPointCut()")
//    public void logBeforeMethodCall(){
//        System.out.println("Method start :-###############S");
//    }
//
//    @After("logMethodPointCut()")
//    public void logAfterMethodCall(){
//        System.out.println("Method completed :-###############S");
//    }


    //ProceedingJoinPoint which helps you to which method is get executed and their info
    //@Around combo of @Before + @After
    @Around("logMethodPointCut()")
    public void logforMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Method start :-> "+proceedingJoinPoint.getSignature().getName());
        //proceed helps you execute method
        proceedingJoinPoint.proceed();

        System.out.println("Method completed :-> "+proceedingJoinPoint.getSignature().getName());
    }
}
