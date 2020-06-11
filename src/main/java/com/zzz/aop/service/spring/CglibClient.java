package com.zzz.aop.service.spring;

import com.zzz.aop.service.facade.Teach;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Title: CglibClient
 * @Package: com.zzz.aop.aop.service.spring
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/5 17:51
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class CglibClient {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TeachService.class);
        enhancer.setCallback(new TeacherInterceptor());
        Teach teach = (Teach)enhancer.create();
        teach.speck();
    }
}
