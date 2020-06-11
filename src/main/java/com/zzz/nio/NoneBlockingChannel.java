package com.zzz.nio;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;

/**
 * @Title: NoneBlockingChannel
 * @Package: com.zzz.aop.nio
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/04/29 0029 16:24
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class NoneBlockingChannel {

    @Test
    public void server() throws Exception {
        ServerSocketChannel sChannel = ServerSocketChannel.open();
        // 切换为非阻塞
        sChannel.configureBlocking(false);
        sChannel.bind(new InetSocketAddress(9898));
        // 选择器
        Selector selector = Selector.open();
        // 通道注册到选择器上
        sChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 轮询选择器就绪数量，select()返回准备就绪的通道数量
        System.out.println("------------------");
        while (selector.select() > 0) {
            // 遍历选择器中的选择键，判断选择键类型，并做相应操作
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    SocketChannel channel = sChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey
                            .channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    buffer.flip();
                    byte[] bytes = new byte[1024];
                    buffer.get(bytes,0,buffer.limit());
                    System.out.println(new String(bytes,0,buffer.limit()));
                    channel.close();
                }
            }
            // 情况选择键
            // TODO
            iterator.remove();
        }
    }

    @Test
    public void client() throws Exception {
        SocketChannel socketChannel = SocketChannel
                .open(new InetSocketAddress("127.0.0.1", 9898));
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(LocalTime.now().toString().getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();

        socketChannel.close();
    }
}
