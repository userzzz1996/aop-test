package com.zzz.controller;

import com.zzz.aop.annotation.Tags;
import oracle.jrockit.jfr.jdkevents.throwabletransform.ConstructorTracerWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title: AOPTestController
 * @Package: com.zzz.aop.controller
 * @Description: ${TODO}(用一句话描述该文件做什么)
 * @Author: zzz
 * @Date: created 2019/11/29 11:03
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
@Controller
@ResponseBody
public class AOPTestController {

    @GetMapping(value = "/test")
    @Tags
    public String test(){
        return "asda";
    }
}
