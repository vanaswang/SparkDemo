package com.vanas.bigdata.chapter10

/**
 * @author Vanas
 * @create 2020-05-30 3:30 下午 
 */
object Scala01_Transform {
    def main(args: Array[String]): Unit = {
        //隐式转换

        val b: Byte = 10
        //Java中基本类型的数值之间存在精度的转换和截取
        //scala中没有精度的概念，编译时会自动由编译器调用java逻辑进行数值操作
        //两个类型如果想要互相转换，那么必须存在关系
        //1.父子类
        //2.接口和实现类

        //本来两个类型之间不存在关系，无法进行类型转换，但是编译器编译时
        //尝试找到对应的转换方法将类型进行转换，让程序编译通过
        //这个自动转换的过程称之为隐式转换，是由编译器完成的，也称之为二次编译
        val i: Int = b

//        val bb: Byte = i
        println(i)
    }
}
