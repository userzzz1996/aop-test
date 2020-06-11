package com.zzz.aop.service.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Title: ProxyTeacherService
 * @Package: com.zzz.aop.aop.service.spring
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/3 15:16
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class ProxyTeacherService implements InvocationHandler {

    TeachService teachService;

    public ProxyTeacherService(TeachService obj){
        this.teachService = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过method.invoke方法动态调用target类方法
        Object result = method.invoke(teachService,args);
        //方法前后可进行边缘操作
        return result;
    }
}
