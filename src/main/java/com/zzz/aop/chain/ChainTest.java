package com.zzz.aop.chain;

/**
 * @Title: ChainTest
 * @Package: com.zzz.aop.aop.chain
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/4 14:18
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */

public class ChainTest {
    static class Demo1 extends AbstractDemo {

        @Override
        public void write() {
            System.out.println("chain demo1");
        }
    }

    static class Demo2 extends AbstractDemo {

        @Override
        public void write() {
            System.out.println("chain demo2");
        }
    }

    static class Demo3 extends AbstractDemo {

        @Override
        public void write() {
            System.out.println("chain demo3");
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo2();
        Demo3 demo3 = new Demo3();
        //形成链式
        demo1.setNext(demo2);
        demo2.setNext(demo3);
        demo1.execute();
    }
}
