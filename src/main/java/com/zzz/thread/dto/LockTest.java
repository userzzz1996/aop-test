package com.zzz.thread.dto;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: LockTest
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/23 10:33
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class LockTest {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    //锁要声明在外边
    private Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {
        final LockTest test = new LockTest();

        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
