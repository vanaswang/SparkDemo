package com.vanas.bigdata.java.chapter01;

/**
 * scala语言是一个完全面向对象的编程语言
 * Java语言不是一个完全面向对象的编程语言
 * object：scala语言中没有静态的语法
 *
 * @author Vanas
 * @create 2020-05-18 10:12 上午
 *
 */
public class HelloScala {
    public static void main(String[] args) {
        System.out.println("hello scala");


        HelloScala.test();
    }
    public static void test(){
        System.out.println("test");
    }
}
