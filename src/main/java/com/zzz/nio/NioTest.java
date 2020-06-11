package com.zzz.nio;

import org.junit.jupiter.api.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Title: NioTest
 * @Package: com.zzz.aop.nio
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/26 0026 16:35
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class NioTest {

    @Test
    public void test1() {

        // 开辟直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        // 判断直接缓冲区和非直接缓冲区
        boolean direct = buffer.isDirect();
    }

    @Test
    public void test2() {

        String string = "abcde";
        // 获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 写入
        buffer.put(string.getBytes());

        // 切换成取模式
        buffer.flip();

        // 读取
        byte[] bytes = new byte[1024];
        buffer.get(bytes, 0, 2);
        System.out.println(new String(bytes));
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        // 标记position位置
        buffer.mark();
        buffer.get(bytes, 2, buffer.remaining());
        System.out.println("---------------mark---------");
        System.out.println(new String(bytes));
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        // 恢复mark位置
        buffer.reset();
        System.out.println("---------------reset---------");

        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        // 载体数组 载体数组的位置 读取的数据量
        buffer.get(bytes, 5, buffer.remaining());
        System.out.println(new String(bytes));

        // 重新读取
        buffer.rewind();
        System.out.println("---------rewind----------");
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        // 清空
        buffer.clear();

    }
}
