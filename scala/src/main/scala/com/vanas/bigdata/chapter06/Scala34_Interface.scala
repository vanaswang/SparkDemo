package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala34_Interface {
    def main(args: Array[String]): Unit = {
        //Scala -特质
        //1.trait 关键字可以声明特质
        //2.可以将trait理解为interface
        //  java中接口可以继承，可以多继承
        //  特质能不能继承？ 可以，并且可以采用with进行多继承
        //3.可以将trait理解为抽象类
        //  java中抽象类，可以继承其他的类,并采用with混入其他的特质
        //  特质能不能继承类,继承其他的类
        //4.将特质混入类中，采用extends关键字或with关键字
        //  将特质理解为抽象类，那么就可以使用extends让子类继承
        //  还可以使用with混入其他的特质
        //  如果特质中存在抽象方法，那么混入的类应该补全方法，否则为抽象的
        //  如果特质中存在具体方法，子类重写方法时，需要使用override关键字
        // 5.Scala可以直接使用java中的代码，scala中没有接口，那么java中的接口在scala中怎么用
        //  java中所有的接口在Scala中都当成特质来使用
    }
}

//声明特质
trait ParentTest334 {

}

trait ParentTest34 {

}

//trait Test34 extends ParentTest34 with ParentTest334 {
//trait Test34 extends Exception with ParentTest34 {
trait Test34 {

    //抽象方法
    def test(): Unit

    //具体方法
    def test1(): Unit = {
        println("test....")
    }

    def sum(i: Int, j: Int): Int = {
        i + j
    }
}

//class User34 extends java.io.Serializable {
class User34 extends Test34 with ParentTest34 with java.io.Serializable {
    def test(): Unit = {

    }
    override def test1(): Unit = {
        println("test....")
    }

}