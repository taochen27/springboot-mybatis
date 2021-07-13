package com.hand.springbootmybatis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @title: TransactionAop
 * @Author Tao
 * @Date: 2021/7/7 17:04
 * @Version 1.0
 */
// 增强类
@Aspect
@Component
public class TransactionAop {
    private Logger logger = LoggerFactory.getLogger(TransactionAop.class);

    @Pointcut("execution(* com.hand.springbootmybatis.service.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beginTransaction() {
        logger.info("before<工号>");
    }

    @After("pointcut()")
    public void afterTransaction() {
        logger.info("after<工号>");
    }

    @AfterReturning(pointcut ="pointcut()", returning = "returnObject")
    public void afterReturning(JoinPoint joinPoint, Object returnObject) {
        logger.info("afterReturning<工号>");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        logger.info("afterThrowing<工号>");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            logger.info("around<工号>");
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
            logger.info("around<工号>");
        }
    }
}
