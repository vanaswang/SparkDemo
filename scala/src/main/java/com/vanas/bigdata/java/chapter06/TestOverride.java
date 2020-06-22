package com.vanas.bigdata.java.chapter06;

/**
 * @author Vanas
 * @create 2020-05-25 2:44 下午
 */
public class TestOverride {
    public static void main(String[] args) {
//        User2 user = new User2();  //40
        Person2 user = new User2();  //多态 40
        System.out.println(user.sum()); //20
        //第一个问题：40
        //第二个问题：40
        //第三个问题：20
        //第四个问题：


    }
}

class Person2 {
    public int i = 10;

    //    public int sum() {
//        return i + 10;
//    }
    public int sum() {
        return getI() + 10;
    }

    public int getI() {
        return i;
    }
}

class User2 extends Person2 {
    public int i = 20;

    //    public int sum() {
//        return i + 20;
//    }
    public int getI() {
        return i;
    }

}
