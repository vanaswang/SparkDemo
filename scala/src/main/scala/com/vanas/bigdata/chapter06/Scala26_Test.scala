package com.vanas.bigdata.chapter06

//使用2种或2种以上的方式构建对象
object Scala26_Test {
    def main(args: Array[String]): Unit = {
        //单例模式
        //1.构造方法私有话
        //2.使用静态的方式获取指定类型对象
        val dept1 = Dept04
        val dept2 = Dept04
        println(dept1 eq dept2)
    }
}

class Dept04 private {
}

//伴生对象只会初始化一次，所以是也i个单例对象
//让Dept04 在伴生对象初始化时创建一次，不就是单例么
object Dept04 {
    val dept = new Dept04

    def apply(): Dept04 = {
        dept
    }
}

