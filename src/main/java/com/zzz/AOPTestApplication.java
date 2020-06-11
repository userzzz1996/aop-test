package com.zzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Title: AOPTestApplication
 * @Package: com.zzz.aop
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @Author: zzz
 * @Date: created 2019/11/29 11:03
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
@SpringBootApplication
//强制Cglib代理
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class AOPTestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(AOPTestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(AOPTestApplication.class, args);
    }

}
