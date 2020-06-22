package com.vanas.bigdata.java.chapter04;


/**
 * @author Vanas
 * @create 2020-05-19 4:31 下午
 */
public class Java_TestOper1 {


    public static void main(String[] args) {
        int i =10;
        int j = i = 20;
        System.out.println(j);

        Thread.yield();
    }

}
