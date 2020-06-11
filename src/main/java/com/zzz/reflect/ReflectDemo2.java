package com.zzz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Title: ReflectDemo2
 * @Package: com.zzz.aop.reflect
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/11 15:58
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class ReflectDemo2 {
    public static void main(String[] args) {
        Class c1 = int.class;
        Class c2 = double.class;
        Class c3 = void.class;
        Field[] field = c3.getFields();
        //Method
        Method[] methods = c3.getMethods();
        Class classA = A.class;
        Method method = null;
        try {
            method = classA.getMethod("print",new Class[]{int.class,int.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Object result = null;
        try {
            //方法无返回值时就会返回空
            result =  method.invoke(new A(),10,10);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class A{
    public void print(int a ,int b){
        System.out.println(a+b);
    }
}