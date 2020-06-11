package com.zzz.aop.test;

import javafx.scene.Parent;
import javafx.scene.media.VideoTrack;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @Title: StaticTest
 * @Package: com.zzz.aop.test
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/01 0001 10:53
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class StaticTest {

    static class Child extends Parent {

    }

    static class Parent {

    }

    public static void execute(Parent parent) {
        System.out.println("parent");
    }

    public static void execute(Child child) {
        System.out.println("child");
    }

    public void add(long a) {
        System.out.println("long....");
    }

    public void add(Object a) {
        System.out.println("Object....");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        StaticTest.execute(parent);
    }

}
