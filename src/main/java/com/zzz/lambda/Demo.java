package com.zzz.lambda;

/**
 * @Title: Demo
 * @Package: com.zzz.aop.lambda
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/16 0016 16:04
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class Demo {
    public static void main(String[] args) {
        // -> 箭头操作符
        // -> 左侧 形参列表 右侧 重写方法方法体的具体内容
        MyInterface myInterface = (a,b) -> {System.out.println("sdj");int i = 1;System.out.println(i);};
        myInterface.print(12,"12");
    }
}

