package com.zzz.designpattern;

/**
 * @Title: Factory
 * @Package: com.zzz.designpattern
 * @Description: 工厂方法
 * @Author: Administrator
 * @Date: created 2020/05/07 0007 10:36
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public abstract class FactoryMethod {
    // 定义一个创建对象的接口，但由其子类决定要实例化哪个类
    abstract Product creatProduct();

    public Product getProduct() {
        Product product = creatProduct();
        return product;
    }

    public static void main(String[] args) {
        FactoryMethod factoryMethod = new Factory1();
        Product product = factoryMethod.creatProduct();
    }

}

class Product {

}

class concreteProduct extends Product {

}

class Factory1 extends FactoryMethod {

    @Override
    Product creatProduct() {
        return new concreteProduct();
    }
}