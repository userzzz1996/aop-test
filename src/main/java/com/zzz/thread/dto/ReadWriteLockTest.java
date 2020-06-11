package com.zzz.thread.dto;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Title: ReadWriteLockTest
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/23 18:52
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class ReadWriteLockTest {
    /**
     * 入参可指定采用公平锁，默认非公平锁
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public void read(Thread thread){
        readWriteLock.readLock().lock();
        try {
            System.out.println("读取开始："+thread.getName());
            Thread.sleep(1000);
        }catch (Exception e){

        }finally {
            System.out.println("读取结束："+thread.getName());
            readWriteLock.readLock().unlock();
        }
    }

    public void write(Thread thread){
        readWriteLock.writeLock().lock();
        try {
            System.out.println("写入开始："+thread.getName());
            Thread.sleep(1000);
        }catch (Exception e){

        }finally {
            System.out.println("写入结束："+thread.getName());
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        new Thread(){
            public void run() {
                readWriteLockTest.read(this);
            };
        }.start();

        new Thread(){
            public void run() {
                readWriteLockTest.read(this);
            };
        }.start();

        new Thread(){
            public void run() {
                readWriteLockTest.write(this);
            };
        }.start();
    }
}
