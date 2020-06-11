package com.zzz.thread.dto;

import java.util.concurrent.Semaphore;

/**
 * @Title: SemaphoreTest
 * @Package: com.zzz.aop.thread.dto
 * @Description: 信号量
 * @Author: zzz
 * @Date: created 2019/12/24 18:46
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class SemaphoreTest extends Thread{

    Semaphore semaphore;

    String name;

    Long time;

    public SemaphoreTest(Semaphore semaphore, String name, Long time) {
        this.semaphore = semaphore;
        this.name = name;
        this.time = time;
    }
    @Override
    public void run (){
        while (semaphore.tryAcquire()){
            System.out.println(name+"加入队里");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"结束任务");
            //注意结束任务要释放信号量
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        SemaphoreTest sks = new SemaphoreTest(semaphore,"sks",1000L);
        SemaphoreTest awm = new SemaphoreTest(semaphore,"awm",3000L);
        SemaphoreTest m4 = new SemaphoreTest(semaphore,"m4",5000L);
        SemaphoreTest ak = new SemaphoreTest(semaphore,"ak",2000L);
        sks.start();
        awm.start();
        m4.start();
        ak.start();
    }
}
