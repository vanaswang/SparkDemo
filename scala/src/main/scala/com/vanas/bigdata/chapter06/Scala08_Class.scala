package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala08_Class {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-Class
        //scala中的class可以继承（extends）父类
        //多态：一个对象在不同场合下所表示的不同的状态
        //scala当省略类型，编译器会自动将构建对象的类型进行推断
        val user = new User08
        println(user)
        //如果需要使用多态操作，那么必须显示声明类型  因为无法自动推断

        val user1 :Parent08 =new User08
        println(user1)
    }
}

//父类
class Parent08 {

}

//子类
class User08 extends Parent08 {

}

