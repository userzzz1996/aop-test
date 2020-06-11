package com.zzz.thread.dto;

/**
 * @Title: Productor
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/19 18:22
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class Productor extends Thread{

    BufferAare bufferAare;

    public Productor(BufferAare bufferAare){
        this.bufferAare = bufferAare;
    }

    @Override
    public void run(){
        while (true){
            bufferAare.product();
        }
    }

}
