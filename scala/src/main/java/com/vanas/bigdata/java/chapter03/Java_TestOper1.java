package com.vanas.bigdata.java.chapter03;

/**
 * @author Vanas
 * @create 2020-05-19 10:44 上午
 */
public class Java_TestOper1 {
    public static void main(String[] args) {
        int i = 0;
//        int j = i++;
//        System.out.println("i=" + i + ",j=" + j);
//      什么叫赋值 将等号的右边的计算结果给左边
//      ++放在变量的后面，先赋值，再加一
//      ++放置在变量的前面，先加一，再赋值
        i = i++;// 1)_a=i++
                // 1.1) _a=i
                // 1.2) i=i+1
        //  2)i=_a
        System.out.println("i=" + i);


    }
}
