package com.zzz.aop.test;

import org.junit.Test;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: CommonTest
 * @Package: com.zzz.aop.test
 * @Description:
 * @Author: Administrator
 * @Date: created 2020/03/17 0017 21:23
 * @Version:1.1.0
 * @Copyright:Copyright (c) 2014 - 2100
 * @Company:ceair
 */
public class CommonTest {

    @Test
    public void test() {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        char[] buffer = new char[1024];
        Map map = new HashMap();
        FileReader fileInputStream = null;
        FileWriter fileOutputStream = null;
        try {
            fileInputStream = new FileReader("d:/a.txt");
            fileOutputStream = new FileWriter("D:/b.txt");
            bufferedReader = new BufferedReader(fileInputStream);
            bufferedWriter = new BufferedWriter(fileOutputStream);
            String i;
            int j = 0;
            while ((i = bufferedReader.readLine()) != null) {
                System.out.println(i);
                // i=fileInputStream.read();
                bufferedWriter.write(i);
                bufferedWriter.newLine();
                j++;
            }
            System.out.println("j==" + j);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
