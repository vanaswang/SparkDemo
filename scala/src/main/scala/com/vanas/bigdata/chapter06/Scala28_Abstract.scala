package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala28_Abstract {
    def main(args: Array[String]): Unit = {
        //Scala-面向对象-抽象

        //抽象类中可以有完整方法
        //如果抽象类中没有不完整的方法，那么子类就无需声明为抽象的，可以直接构建对象
        println(new SubUser28())

        //如果子类重写父类的完整方法，需要显示增加override关键字来修饰
        //如果子类重写父类的抽象方法，需要直接补充完整即可，或采用override关键字修饰
        //
    }

}

abstract class User28 {
    def test(): Unit = {

    }
}

class SubUser28 extends User28 {
    override def test(): Unit = {

    }
}

