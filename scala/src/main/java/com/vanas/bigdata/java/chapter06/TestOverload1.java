package com.vanas.bigdata.java.chapter06;

import org.junit.Test;

/**
 * @author Vanas
 * @create 2020-05-25 2:28 下午
 */
public class TestOverload1 {
    public static void main(String[] args) {
        User1 user = new User1();
        test(user);

        Person user1 = new User1();
        test(user1);

    }

    public static void test(Person person) {
        System.out.println("person");
    }

    public static void test(User1 user1) {
        System.out.println("user1...");
    }
}

class Person {

}

class User1 extends Person {

}