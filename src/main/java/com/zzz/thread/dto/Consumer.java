package com.zzz.thread.dto;

/**
 * @Title: Consumer
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/19 18:25
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class Consumer extends Thread {

    BufferAare bufferAare;

    public Consumer(BufferAare bufferAare){
        this.bufferAare = bufferAare;
    }

    @Override
    public void run(){
        while (true){
            bufferAare.consume();
        }

    }
}
