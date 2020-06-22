package com.vanas.bigdata.java.chapter05;

/**
 * @author Vanas
 * @create 2020-05-20 2:13 下午
 */
public class Java_Method {
    public static void main(String[] args) {
        regUser("zhangsan",null);
    }

    public static void regUser(String name,String password){
        if (password==null){
            password="000000";
        }
    }
}
