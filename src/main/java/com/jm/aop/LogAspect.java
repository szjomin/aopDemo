package com.jm.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Aspect
@Component
public class LogAspect {
	
    @Pointcut("execution(public * com.*.*.*.controller.*.*(..))")
    public void logPointcut(){

    }

    @Before("logPointcut()")
    public void  methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        
        System.out.println("===============插入日志===============");
        //打印请求内容
        System.out.println("---------------请求内容---------------");
        System.out.println("请求地址:"+request.getRequestURL().toString());
        System.out.println("请求方式:"+request.getMethod());
        System.out.println("请求类方法:"+joinPoint.getSignature().getName());
        System.out.println("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
        System.out.println("---------------请求内容---------------");
    }


    @AfterReturning(returning = "o",pointcut = "logPointcut()")
    public void methodAfterReturning(Object o){
    	
    	
    	System.out.println("===============返回内容===============");
    	System.out.println("返回的内容:"+ o.toString());
    	System.out.println("===============返回内容===============");
    }


    @AfterThrowing(pointcut = "logPointcut()",throwing = "e")
    public void logThrowing(JoinPoint joinPoint,Throwable e){
    	System.out.println("***************抛出异常***************");
    	System.out.println("请求类方法:"+joinPoint.getSignature().getName());
    	System.out.println("异常内容:"+e);
    	System.out.println("***************抛出异常***************");
    }

}
