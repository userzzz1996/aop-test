package com.zzz.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Title: Demo
 * @Package: com.zzz.aop.stream
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/17 0017 16:34
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class Demo {

    public static void main(String[] args) {
        // 获取流的方法

        // 1.Collection的stream方法
        List<String> list = new ArrayList();
        Stream<String> stream = list.stream();
        Stream<String> stringStream = list.parallelStream();

        // 2.Arrays的stream方法
        Stream<String> stream1 = Arrays.stream(new String[] { "as", "asd"});

        // 3.Stream中的of方法
        Stream<Object> stream2 = Stream.of("asd", 12, new Demo());

        // 4.Stream中的iterate方法
        Stream<Integer> stream3 = Stream.iterate(2, x -> x = x + 1);
        // foreach方法传入一个消费型接口，所以遍历后的相关操作会在这个接口中进行
        stream3.forEach(System.out::println);

        // 5.Stream中的generate方法
        // 传入一个供给型接口
        Stream<Integer> stream4 = Stream.generate(() -> 2);
        stream4.forEach(System.out::println);
    }
}
