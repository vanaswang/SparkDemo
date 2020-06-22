package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala12_Field {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-属性
        //好多框架已经不需要setget了 可以直接通过属性装配起来
        //spring=>自动装配=>自动完成两个对象关系的组合（User，Dept）
    }

    //内部类
    class User {
        var name: String = _

        def setName(name: String): Unit = {
            this.name = name
        }

        def getName():String = {
            return this.name
        }

    }


}

