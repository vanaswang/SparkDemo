package com.vanas.bigdata.java.chapter01;

import java.lang.reflect.Field;

/**
 * @author Vanas
 * @create 2020-05-18 3:17 下午
 */
public class Test03_String {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //不可变字符串 String

//        StringBuilder StringBuffer
//        final 修饰变量，一旦初始化后，值（内存地址）无法发生改变
//        String类一旦初始化后没有提供任何方法来改变字符串的内容
//        而是提供产生新的字符串的方法
        String s = " a b ";
//        ，,
//        s = s.trim();//去掉收尾半角空格 不能去掉中文和日文的空格
//        System.out.println("!" + s + "!");

//        反射
        Class<? extends String> aClass = s.getClass();
        Field f = aClass.getDeclaredField("value");
//        获取属性的值
        f.setAccessible(true);
        char[] cs = (char[]) f.get(s);
        cs[2] = 'd';
        System.out.println(s);

    }
}
