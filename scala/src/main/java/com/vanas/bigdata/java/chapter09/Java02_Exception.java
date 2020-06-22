package com.vanas.bigdata.java.chapter09;

/**
 * @author Vanas
 * @create 2020-05-30 2:45 下午
 */
public class Java02_Exception {
    public static void main(String[] args) {
        try {
            //可能会发生异常的代码
            int i = 0;
            int j = 10 / i;
            //异常捕捉的顺序：先捕捉异常范围小的异常，然后再捕捉范围大的异常
        } catch (java.lang.ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException....");
        } catch (Exception e) {
            //如果发生异常，处理的方案
            e.printStackTrace();
        } finally {
            //无论是否发生异常，都会执行的最终代码
            //资源的释放
        }
    }
}
