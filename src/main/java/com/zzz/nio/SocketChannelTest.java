package com.zzz.nio;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Title: SocketChannel
 * @Package: com.zzz.aop.nio
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/29 0029 10:50
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class SocketChannelTest {

    @Test
    public void client() throws Exception {
        // 获取通道
        SocketChannel socketChannel = SocketChannel
                .open(new InetSocketAddress("127.0.0.1", 8010));
        FileChannel fileChannel = FileChannel.open(Paths.get("d:/1.txt"),
                StandardOpenOption.READ);
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        // 发送完毕后要执行shutdownOutput()方法，否则客户端一直在监听造成阻塞
        socketChannel.shutdownOutput();
        //TODO 开辟直接内存可能会报错，因为直接内存中不受jvm管理
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(buffer) != -1) {
            byte[] bytes = new byte[buffer.limit()];
            buffer.flip();
            buffer.get(bytes,0,buffer.limit());
            System.out.println(new String(bytes));
            System.out.println();
            buffer.clear();
        }
        fileChannel.close();
        socketChannel.close();

    }

    @Test
    public void server() throws Exception {

        // 服务端channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 绑定端口号
        channel.bind(new InetSocketAddress(8010));

        // accept获取客户端的请求信息
        SocketChannel accept = channel.accept();
        FileChannel outChannel = FileChannel.open(Paths.get("d:/9.txt"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (accept.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        buffer.put("数据存贮完毕!".getBytes());
        buffer.flip();
        accept.write(buffer);

        accept.close();
        outChannel.close();
        channel.close();
    }
}
