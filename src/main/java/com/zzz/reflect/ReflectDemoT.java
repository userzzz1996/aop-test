package com.zzz.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: ReflectDemoT
 * @Package: com.zzz.aop.reflect
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/12 11:09
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class ReflectDemoT {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Class c = list.getClass();
        try {
            Method method = c.getMethod("add",Object.class);
            method.invoke(list,10);
            System.out.println(list.size());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
