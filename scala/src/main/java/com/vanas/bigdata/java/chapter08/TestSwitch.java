package com.vanas.bigdata.java.chapter08;

        import sun.java2d.pipe.SpanIterator;

/**
 * @author Vanas
 * @create 2020-05-30 9:05 上午
 */
public class TestSwitch {
    public static void main(String[] args) {
        int a = 10;
        //switch穿透现象 没跳出 继续执行
        switch (a){
            case  5:
                System.out.println("5");
            case  10:
                System.out.println("10");
            case  20:
                System.out.println("20");
            default:
                System.out.println("other");
        }
    }
}
