package com.zzz.string;


import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * @Title: StringEqualTest
 * @Package: com.zzz.aop.string
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/12 14:22
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */

public class StringEqualTest {
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        // 两个字符串相加底层会生成StringBuilder对象，然后使用append来拼接
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());

        // 简单的说，如果整型字面量的值在-128 到 127 之间，那么不会 new 新的 Integer对象，而是直接引用常量池中的
        // Integer 对象，所以上面的面试题中 f1f4 的结果是 false。
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);


        List list = new Vector();
        list.add("asf");
        list.add("asd");
        list.add("asasd");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("asd")) {
                iterator.remove();
            }
        }
        for (Object o:
        list) {
            System.out.println(o);
        }
        System.out.println(list.size());
    }
}
