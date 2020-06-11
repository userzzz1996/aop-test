package com.zzz.thread.dto;

/**
 * @Title: RunableDemo
 * @Package: com.zzz.aop.thread.dto
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/18 15:19
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class RunableDemo implements Runnable {

    private int i;

    Demo demo;

    RunableDemo(int i, Demo demo) {
        this.i = i;
        this.demo = demo;
    }

    @Override
    public void run() {
        synchronized (demo){
            demo.play(i);
        }

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        RunableDemo demo1 = new RunableDemo(1, demo);
        Thread thread1 = new Thread(demo1);
        thread1.start();
        RunableDemo demo2 = new RunableDemo(2, demo);
        Thread thread2 = new Thread(demo2);
        thread2.start();
        RunableDemo demo3 = new RunableDemo(3, demo);
        Thread thread3 = new Thread(demo3);
        thread3.start();
    }
}

class Demo {
    public void play(int i) {
        System.out.println("线程开始：" + i);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程结束：" + i);
    }
}
