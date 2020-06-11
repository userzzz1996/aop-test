package com.zzz.aop.service.spring;

import com.zzz.aop.service.facade.Teach;

/**
 * @Title: TeachService
 * @Package: com.zzz.aop.aop.service.spring
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/3 15:14
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class TeachService implements Teach {
    @Override
    public void speck() {
        System.out.println("speck method");
    }
}
