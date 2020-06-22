package com.vanas.bigdata.java.chapter06;

/**
 * @author Vanas
 * @create 2020-05-25 3:35 下午
 */
public class Java08_Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        AAA aaa = new AAA();
        //方法的提供者：com.vanas.bigdata.java.chapter06.AAA
        //方法的调用者：com.vanas.bigdata.java.chapter06.Java08_Clone
//        aaa.clone();//因为同包

//        Object aaa = new AAA(); error
        //方法的提供者：java.lang.Object
        //方法的调用者：com.vanas.bigdata.java.chapter06.Java08_Clone
        aaa.toString();
    }
}

class AAA {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}