package com.zzz.thread.dto;

import java.util.concurrent.*;

/**
 * @Title: ThreadPoolExecutorTest
 * @Package: com.zzz.aop.thread.dto
 * @Description: 线程池
 * @Author: zzz
 * @Date: created 2019/12/25 15:42
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class ThreadPoolExecutorTest {

    public static LinkedBlockingQueue queue = new LinkedBlockingQueue(100);
    /**
     * 创建线程池
     */
    public static Executor executor = new ThreadPoolExecutor(5, 10, 5,
            TimeUnit.SECONDS, queue,new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
        for (int i = 0;i < 100;i++){
            int j = i;
            executor.execute(new Runnable(){
                @Override
                public void run() {
                    System.out.println(j+"线程执行中");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待队里状态:"+queue.size());
                }
            });
        }
    }
}
