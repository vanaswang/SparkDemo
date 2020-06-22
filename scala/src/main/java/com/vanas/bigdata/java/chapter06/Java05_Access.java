package com.vanas.bigdata.java.chapter06;

/**
 * @author Vanas
 * @create 2020-05-23 11:34 上午
 */
public class Java05_Access {
    //
    public static void main(String[] args) {

        User05 user = new User05();
        //Object 提供的方法：private、public、protected
        //访问权限：权利和限制
        //protected   ：同类、同包、子类
        //方法的提供者:java.long.Object：
        //方法的调用者：com.vanas.bigdata.java.chapter06.Java05_Access
        //问题1：方法的调用者不是User05？
        //  com.vanas.bigdata.java.chapter06.Java05_Access
        //问题2：点的作用？
        //        从属关系
        //        user.clone(); //error
        //问题3：Java05_Access和Object没有父子关系？
        //
        //给user对象的name属性赋了一个值为zhangsan
        user.name = "zhangsan";


    }
}

//声明一个类，默认会继承Object类
class User05 {
    public String name;
}