package com.zzz.aop.test;

import com.zzz.aop.service.facade.Teach;
import com.zzz.aop.service.spring.ProxyTeacherService;
import com.zzz.aop.service.spring.TeachService;

import java.lang.reflect.Proxy;

/**
 * @Title: AopTest
 * @Package: com.zzz.aop.test
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/3 15:27
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class AopTest {

    public static void main(String[] args) {
        // 声明接口对象
        Teach teach = (Teach) Proxy.newProxyInstance(
                AopTest.class.getClassLoader(), new Class[] { Teach.class },
                new ProxyTeacherService(new TeachService()));
        teach.speck();
    }
}
