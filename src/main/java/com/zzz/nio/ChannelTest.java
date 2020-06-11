package com.zzz.nio;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * @Title: ChannelTest
 * @Package: com.zzz.aop.nio
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/28 0028 14:53
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class ChannelTest {

    @Test
    public void test1() throws Exception {
        /*
         * 获取通道的方式 1.java对支持通道的类型提供了getChannel()方法
         * 2.jdk1.7之后,针对各个通道的static方法open() 3.Files.newByteChannel()
         */

        FileChannel in = FileChannel.open(Paths.get("d:/a.txt"),
                StandardOpenOption.READ);
        File file = new File("d:/c.txt");
        file.createNewFile();
        FileChannel out = FileChannel.open(Paths.get("d:/c.txt"),
                StandardOpenOption.WRITE);

        // 缓冲区 capacity limit position mark
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (in.read(buffer) != -1) {
            // 切换写模式
            buffer.flip();
            out.write(buffer);
            // 切记clear缓冲区
            buffer.clear();
        }
        // 关闭通道
        in.close();
        out.close();
    }

    @Test
    public void test2() throws Exception {
        FileChannel in = FileChannel.open(Paths.get("d:/a.txt"),
                StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("d:/d.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.READ,
                StandardOpenOption.CREATE);
        // TODO 映射文件 MappedByteBuffer 继承自 ByteBuffer
        MappedByteBuffer inMappedByteBuffer = in
                .map(FileChannel.MapMode.READ_ONLY, 0, in.size());
        MappedByteBuffer outMappedByteBuffer = out
                .map(FileChannel.MapMode.READ_WRITE, 0, in.size());
        // TODO 直接在内存映射文件（直接内存）中进行读写操作，不走channel(不用缓冲区存储数据)，但直接内存中操作不受应用程序管理
        // jvm 堆内存的数组缓冲
        byte[] buffer = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(buffer);
        outMappedByteBuffer.put(buffer);
        in.close();
        out.close();
    }

    @Test
    public void test3() throws Exception {
        FileChannel in = FileChannel.open(Paths.get("d:/a.txt"),
                StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("d:/f.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.READ,
                StandardOpenOption.CREATE);
        // 通道间数据传递
        // in.transferTo(0,in.size(),out);
        out.transferFrom(in, 0, in.size());
        in.close();
        out.close();
    }

    @Test
    public void test4() throws Exception {
        //分散读取 聚集写入
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:/1.txt","rw");
        FileChannel in = randomAccessFile.getChannel();
        //两个缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(2048);
        ByteBuffer[] byteBuffers = {buffer1,buffer2};
        in.read(byteBuffers);
        //TODO 聚集写入时，所有缓冲区都需要切换模式
        Arrays.stream(byteBuffers).forEach(buffer -> buffer.flip());
        RandomAccessFile randomAccessFile1 = new RandomAccessFile("d:/2.txt","rw");
        FileChannel out = randomAccessFile1.getChannel();
        out.write(byteBuffers);
    }
}
