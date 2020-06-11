package com.zzz.aop.test;

import com.sun.javafx.scene.control.behavior.ListCellBehavior;
import com.zzz.string.Person;
import jdk.nashorn.internal.objects.NativeUint8Array;
import org.aspectj.weaver.ast.Var;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Title: Test
 * @Package: com.zzz.aop.test
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/24 0024 17:33
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class Test {

    public static final String s1 = "122";

    public static final String s2 = "133";

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

        //todo 一个类的Class对象只有一个，并且是放在堆中的，类的元数据（类的方法代码、方法名、变量名等）才是放在方法区中的
        String s3 = "122133";
        System.out.println(s3 == s1+s2);
    }

}
