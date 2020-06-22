package com.vanas.bigdata.java.chapter09;

import java.util.List;

/**
 * @author Vanas
 * @create 2020-05-30 2:18 下午
 */
public class Java01_Exception {
    public static void main(String[] args) {
        User user = null; //NullPointerException
//        System.out.println(user);
        //空指针异常：调用一个为空（null）对象的成员方法或成员属性会发生空指针异常
        //JVM执行程序发生的错误，不是源码中的错误，是字节码运行的错误
        System.out.println(user.age);

        //age(Integer) =>test=>age(int)
        //拆箱操作可能会导致空指针异常
        //拆箱：Integer.intValue:()
//        test(user.age); //异常 NullPointerException

        //装箱Integer.valueOf
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1==i2); //true
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i3==i4); //false

        //包装类型的数据比较，一般哟个equals方法
        //List.iterator:()(member)
        //所有可迭代的对象都可以使用增强for循环
        List list = null;
        for (Object obj : list) {
            System.out.println(obj);
        }

    }

    public static void test(int age) {
        System.out.println("年龄=" + age);
    }
}

class User {
    //    public Integer age;
    public static Integer age;
    public static Integer id;
}