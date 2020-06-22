package com.vanas.bigdata.java.chapter06;

import org.junit.Test;

/**
 * @author Vanas
 * @create 2020-05-25 2:13 下午
 */
public class Java07_Overload {
    public static void main(String[] args) {
        byte b = 10;

        //byte b(x)
        //0000 1010 =>byte =10
        //0000 0000 0000 1010 => short =10
        //0000 0000 0000 0000 0000 0000 0000 1010 => int  =10
        test(b);

    }

//    public static void test(byte b) {
//        System.out.println("bbbbb");
//    }

//    public static void test(short b) {
//        System.out.println("sssss");
//    }

    public static void test(char b) {
        System.out.println("cccc");
    }

    public static void test(int b) { //不可能是char 因为有精度存在里面
        System.out.println("iiii");
    }
}
