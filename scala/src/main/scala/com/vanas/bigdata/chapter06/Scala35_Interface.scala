package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala35_Interface {
    def main(args: Array[String]): Unit = {
        //Scala -特质-初始化顺序
        //java中接口和父子类无关

        //类，特质的初始化顺序
        //1.类如果有父类，而父类混入特质，而特质1又继承特质2
        //2.那么特质2会先初始化
        //3.然后特质1再初始化
        //4.接下来父类初始化
        //5.如果当前类还有特质的话，那么特质会先初始化
        //6.当前类初始化
        new SubUser35()
        //aaaa
        //bbbb
        //dddd => parent class
        //cccc => trait
        //eeee => child class

    }
}

trait Parent35 {
    println("aaaa")  //初始化只有一次
}

trait Test35 extends Parent35 {
    println("bbbb")
}

trait SubTest35 extends Parent35 {
    println("cccc")

}

class User35 extends Test35 {
    println("dddd")

}

class SubUser35 extends User35 with SubTest35 {
    println("eeee")
}

