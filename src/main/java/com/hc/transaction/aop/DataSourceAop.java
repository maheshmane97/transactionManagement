package com.hc.transaction.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAop {

    //I want to see when transaction will create
    //invoke this method when Transactional Object calls getConnection(), close(), commit(), rollback()
    @Around("target(javax.sql.DataSource)")
    public Object dataSourceConnectionAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("DataSource Tracker ::==>> "+proceedingJoinPoint.getSignature().getName());

        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("DataSource Tracker ::==>> "+proceedingJoinPoint.getSignature().getName());
        return proceed;
    }
}
