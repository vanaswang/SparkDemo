package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 8:40 上午
 */
//package test {
//
//    class UserAAA {
//
//    }
//    package sub{
//
//    }
//
//}

object Scala24_QA {
    def main(args: Array[String]): Unit = {

        //
        val dept0: Dept02 = Dept02 ()// object ...apply
        dept0() //classs ...apply

    }

}

class Dept02 {
    def apply() = {
        println("apply ... class ...")
    }
}

object Dept02 {  //用的多
    def apply(): Dept02 = {
        println("apply ...object")
        new Dept02()
    }
}