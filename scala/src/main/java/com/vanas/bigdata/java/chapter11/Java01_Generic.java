package com.vanas.bigdata.java.chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vanas
 * @create 2020-06-01 8:53 上午
 */
public class Java01_Generic {
    public static void main(String[] args) {
        //泛型-JDK1.5
        //泛型类
        //泛型方法
        //类型约束
        List list1 = new ArrayList();
        List<String> list = new ArrayList<String>();

        //类型擦除
        //JVM没有泛型的概念，所以泛型其实在编译器层次起作用
        List<Integer> list2 = new ArrayList<Integer>();
        //test(list);
        //泛型的问题
        //数据类型和使用的泛型不是一个层面的东西
        //如果能够泛型转换的化，那么底层就会出现类型转换
        //那么可能会出现风险，编译器不允许这种情况出现
        List<String> stringList = new ArrayList<String>();
        //test(stringList);

        //泛型的使用
        //为了让泛型使用的更加方便，java提供了特殊操作
        //< ? extends User > or < ? super User >
        //泛型其实在两个维度进行类型的操作
        //外部类型：List
        //内部类型：<String>
        //如果内部类型相同，那么类型是可以存在上下级关系的
        test1(stringList);

        //泛型的使用特点



    }

    public static void test1(Collection<String> list) {

    }

    public static void test(List<Object> list) {

    }
}
