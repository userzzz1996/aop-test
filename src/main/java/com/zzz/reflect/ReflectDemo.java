package com.zzz.reflect;

/**
 * @Title: ReflectDemo
 * @Package: com.zzz.aop.reflect
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/11 15:00
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class ReflectDemo {

    public static void main(String[] args) {
        // 通过类的class变量获取
        Class c1 = Fool.class;
        // 通过该类的实例对象获取该类的类类型
        Fool fool = new Fool();
        Class c2 = fool.getClass();
        // 通过Class类中静态方法Class.forname获取
        try {
            Class c3 = Class.forName("com.zzz.aop.reflect.Fool");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 无论如何获取，一个类只有一个类类型
        System.out.println(c1 == c2);

        try {
            //通过类的类型获取类的实例对象
            Fool fool1 = (Fool)c2.newInstance();
            fool1.start();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

 class Fool {
  void start(){
      System.out.println("start fool1");
  }
}