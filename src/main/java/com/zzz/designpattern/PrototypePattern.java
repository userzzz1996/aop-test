package com.zzz.designpattern;

/**
 * @Title: PrototypePattern
 * @Package: com.zzz.designpattern
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/05/07 0007 18:14
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Product1 product1 = new Product1();
        //原型模式，Object中提供了浅克隆的clone()方法
        Product1 clone = (Product1) product1.clone();
    }
}

class Product1 implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}