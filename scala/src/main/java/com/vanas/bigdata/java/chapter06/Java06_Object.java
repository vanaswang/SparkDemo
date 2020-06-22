package com.vanas.bigdata.java.chapter06;

/**
 * @author Vanas
 * @create 2020-05-25 6:22 下午
 */
public class Java06_Object {
    public static void main(String[] args) {
        User06 user = new User06();
        user.test();

        System.out.println(user.hashCode());
    }
}

class person {
    public void test() {
        System.out.println("person...");
    }

}

class User06 extends Person {
    public void test() {
        System.out.println("user...");
    }

    public int superHashCode() {
        return super.hashCode();
    }

}
