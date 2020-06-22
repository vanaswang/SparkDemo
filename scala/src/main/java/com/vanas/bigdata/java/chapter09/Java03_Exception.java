package com.vanas.bigdata.java.chapter09;

import com.vanas.bigdata.chapter09.Dept;

/**
 * @author Vanas
 * @create 2020-05-30 2:45 下午
 */
public class Java03_Exception {
    public static void main(String[] args) throws Exception {
        //Java在调用scala对象时，并没有明确处理异常
        //如果想要在处理时，明确异常的处理，那么需要在scala对象的方法前增加注解
        //@throws[异常类型]
        Dept dept = new Dept();
        dept.test();
    }
}
