package com.vanas.bigdata.java.chapter03;

/**
 * @author Vanas
 * @create 2020-05-19 10:44 上午
 */
public class Java_TestOper3 {
    public static void main(String[] args) {
        String s = "";
//        String s = null 不会空指针异常 因为短路与 && 到不了后面
        System.out.println(isNotEmpty(s));

    }

    public static boolean isNotEmpty(String s) {
        return s != null && !s.trim().equals("");
    }
}
