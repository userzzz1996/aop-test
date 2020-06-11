package com.zzz.thread.dto;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Title: FutureTaskTest
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/24 11:00
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
 public class CallObject implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("获取主线程所需资源");
        Thread.sleep(5000);
        System.out.println("获取完毕！");
        return "主线程所需资源";
    }

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask(new CallObject());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("准备其他东西");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("其他东西准备完成");
        while (futureTask.isDone()){
            System.out.println("资源准备完成");
            System.out.println("开始干活！");
        }
        try {
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
