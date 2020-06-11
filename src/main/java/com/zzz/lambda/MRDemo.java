package com.zzz.lambda;

import java.util.function.BiPredicate;
import java.util.function.Supplier;

/**
 * @Title: MRDemo
 * @Package: com.zzz.aop.lambda
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/17 0017 14:16
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class MRDemo {
    public static void main(String[] args) {
        Student student = new Student("lili",12);
        //实现接口的抽象方法必须与方法引用的方法的参数列表和返回值保持一致
        Supplier<String> supplier = () -> student.getName();//方法引用的方法
        supplier.get();//接口抽象方法

        //方法引用
        Supplier<Integer> supplier1 = student::getAge;
        supplier1.get();
        System.out.println(supplier1.get());

        //类名::非静态方法
        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);
        System.out.println(biPredicate.test("as","as"));

        BiPredicate<String,String> biPredicate2 =String::equals;
        System.out.println(biPredicate2.test("as","as"));
    }

}

class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}