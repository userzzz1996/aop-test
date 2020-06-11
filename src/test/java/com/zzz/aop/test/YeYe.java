package com.zzz.aop.test;

/**
 * @Title: YeYe
 * @Package: com.zzz.aop.test
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/06/10 0010 14:53
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class YeYe {
    static {
        System.out.println("YeYe静态代码块");
    }
}

class Father extends YeYe {
    public static String strFather = "HelloJVM_Father";
    static {
        System.out.println("Father静态代码块");
    }
}

class Son extends Father {
    public static String strSon = "HelloJVM_Son";
    static {
        System.out.println("Son静态代码块");
    }
}

class InitiativeUse {
    public static void main(String[] args) {
        System.out.println(Son.strFather);
    }
}
