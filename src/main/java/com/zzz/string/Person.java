package com.zzz.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Person
 * @Package: com.zzz.aop.string
 * @Description:
 * @Author: zzz
 * @Date: created 2019/12/17 18:40
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
 public class Person {

    private String name;

    public Person(){

    }

    public Person(String name){
        this.name = name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhang"));
        list.add(new Person("zhao"));
        list.add(new Person("li"));
        list.parallelStream().forEach(
                x -> {
                System.out.println(x.name);
                }
        );
    }

}

