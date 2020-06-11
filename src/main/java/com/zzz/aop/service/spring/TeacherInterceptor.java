package com.zzz.aop.service.spring;

import org.aopalliance.intercept.MethodInvocation;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Title: TeacherInterceptor
 * @Package: com.zzz.aop.aop.service.spring
 * @Description: cglib代理
 * @Author: zzz
 * @Date: created 2019/12/5 17:46
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class TeacherInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects,
            MethodProxy methodProxy) throws Throwable {

        Object result = methodProxy.invokeSuper(o, objects);

        return result;
    }
}
