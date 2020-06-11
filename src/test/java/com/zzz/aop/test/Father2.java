package com.zzz.aop.test;

/**
 * @Title: ClassFather2
 * @Package: com.zzz.aop.test
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/06/10 0010 10:55
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class Father2 {
    public static String strFather = "HelloJVM_Father";
    static {
        System.out.println("Father静态代码块");
    }
}

class Son2 extends Father2 {
    public static String strSon = "HelloJVM_Son";
    static {
        System.out.println("Son静态代码块");
    }
}

class InitativeUseTest2 {
    public static void main(String[] args) {
        System.out.println(Son2.strSon);
    }
}
