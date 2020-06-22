package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala33_Interface {
    def main(args: Array[String]): Unit = {
        //特质
        //动态扩展功能，遵循OCP开发原则

        //1.特质中不仅仅有抽象方法，还可以有具体的方法
        //2.如果对象声明后想要扩展功能，怎么办？
        //3.特质(混入with)
        val mysql = new MySQL33 with Operate33 //扩展功能

        mysql.select()
        mysql.insert()

    }
}


trait Operate33 {
    def insert(): Unit = {
        print("insert data...")
    }
}

class MySQL33 {
    //class MySQL extends Operate33 {    //继承也不好 也是改源码了
    //    def insert(): Unit ={
    //        print("insert data...")
    // }     //不好 对源码做了改变 影响不确定
    def select(): Unit = {
        println("select data...")
    }
}


