package com.zzz.thread.dto;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Title: CyclicBarrierTest
 * @Package: com.zzz.aop.thread.dto
 * @Description: 栅栏
 * @Author: zzz
 * @Date: created 2019/12/24 16:29
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class CyclicBarrierTest extends Thread {

    private String name;

    private CyclicBarrier cyclicBarrier;

    private Long time;

    CyclicBarrierTest(String name, CyclicBarrier cyclicBarrier, Long time) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(name + "我上号了！");
        try {
            Thread.sleep(time);
            //同一个栅栏内所有线程都到栅栏时，后面的逻辑才执行
            cyclicBarrier.await();
            System.out.println(name + "开打开打！");
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //构造栅栏
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        CyclicBarrierTest sks = new CyclicBarrierTest("sks",cyclicBarrier,0L);
        CyclicBarrierTest awm = new CyclicBarrierTest("awm",cyclicBarrier,0L);
        CyclicBarrierTest ak = new CyclicBarrierTest("ak",cyclicBarrier,3000L);
        CyclicBarrierTest m4 = new CyclicBarrierTest("m4",cyclicBarrier,6000L);
        sks.start();
        awm.start();
        ak.start();
        m4.start();

    }
}
