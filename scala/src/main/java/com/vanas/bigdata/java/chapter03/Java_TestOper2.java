package com.vanas.bigdata.java.chapter03;

/**
 * @author Vanas
 * @create 2020-05-19 10:44 上午
 */
public class Java_TestOper2 {
    public static void main(String[] args) {

//        阶乘：1个大于1的阶乘等于这个数乘以它-1的阶乘
        //5！=5*4！=5*4*3*2*1

        System.out.println(test(5));
    }

    public static int test(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * test(num - 1);//java.lang.StackOverflowError
        }

    }
}
