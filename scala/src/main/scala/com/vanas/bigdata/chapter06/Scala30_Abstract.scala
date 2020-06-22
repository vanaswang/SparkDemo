package com.vanas.bigdata.chapter06
/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala30_Abstract {
    def main(args: Array[String]): Unit = {
        //Scala-面向对象-抽象
        new SubUser30()
        //override 到底发生了声明事情
        //1.println(age)其实调用的子类的age的get方法
        //2.println方法的位置：在父类初始化时进行调用的
        //3.父类在初始化的时候，子类其实时没有初始化的，只有系统的默认值0
    }
}

abstract class User30 {
//class User30{
    val age: Int = 20
    println(age)    //0  age属性的get方法，成员方法，动态绑定

}

class SubUser30 extends User30 {
    override val age: Int = 30 //get方法
}

