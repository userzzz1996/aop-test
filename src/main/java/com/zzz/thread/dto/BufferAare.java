package com.zzz.thread.dto;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: BufferAare
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/19 18:08
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class BufferAare {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    /**
     * 缓冲池中产品数量
     */
    private static int num = 0;

    private final int max = 100;

    public void product() {
        lock.lock();
        try {
            if (num >= max) {
                // Wait是Obeject类的方法
                System.out.println("stop produce！");
                // wait();
                condition.await();
                System.out.println("after wait");
            }
            num++;
            Thread.sleep(500);
            System.out.println("生产进行中，目前数量：" + num);
            // notifyAll();
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void consume() {
        try {
            lock.lock();
            if (num < 1) {
                System.out.println("stop consume! ");
                // wait();
                condition.await();
            }
            num--;
            Thread.sleep(500);
            System.out.println("产品消费中，目前数量：" + num);
            // notifyAll();
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

}
