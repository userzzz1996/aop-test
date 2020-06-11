package com.zzz.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Title: TagsAspect
 * @Package: com.zzz.aop.aop.aspect
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @Author: zzz
 * @Date: created 2019/11/29 14:44
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
@Aspect
@Component
public class TagsAspect {

    @Pointcut("@annotation(com.zzz.aop.aop.annotation.Tags)")
    public void tagsPointCut(){
    }

    @Around("tagsPointCut()")
    public Object cancel(ProceedingJoinPoint joinPoint)throws Throwable{
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //接口原始操作
        Object result  = joinPoint.proceed();
        return method.getReturnType().getName();
    }
}

