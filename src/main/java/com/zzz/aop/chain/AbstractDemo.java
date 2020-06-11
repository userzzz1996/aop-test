package com.zzz.aop.chain;

/**
 * @Title: AbstractDemo
 * @Package: com.zzz.aop.aop.chain
 * @Description: 责任链抽象类
 * @Author: zzz
 * @Date: created 2019/12/4 11:12
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public abstract class AbstractDemo {
    /**
     * 装配下一个对象
     */
    private AbstractDemo next;

    public AbstractDemo getNext() {
        return next;
    }

    public void setNext(AbstractDemo next) {
        this.next = next;
    }

    /**
     * 抽象方法
     */
    public abstract void write();

    public void execute(){
        write();
        if (null!= next){
            //递归回去
            next.execute();
        }
    }
}
