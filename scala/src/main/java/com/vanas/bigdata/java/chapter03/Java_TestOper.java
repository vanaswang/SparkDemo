package com.vanas.bigdata.java.chapter03;

/**
 * @author Vanas
 * @create 2020-05-19 10:44 上午
 */
public class Java_TestOper {
    public static void main(String[] args) {
        String a = new String("abc");
        String b = new String("abc");

        System.out.println((a == b)); //f
        System.out.println(a.equals(b)); //t

    }
}
