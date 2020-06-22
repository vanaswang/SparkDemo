//package com.vanas.bigdata.chapter06
package com
package vanas
package bigdata
package chapter06 {

    class User03 {

    }
    package childPackage {
        /**
         * @author Vanas
         * @create 2020-05-23 10:51 上午
         */
        object Scala03_Object {

            def main(args: Array[String]): Unit = {
                //Scala - 面向对象-Package
                //1。package和源码文件的物理路径没有关系
                //scala会按照package的声明编译指定路径的class
                //2。package关键字可以多次声明
                //  当前类编译后会在最后的package所在的包中生成class文件
                //3。 package可以使用层级结构
                //        在package包名的后面增加大括号，设定作用域范围以及层级关系
                //        子包可以直接访问父包中的内容，无需导入
                //4。包也可以当作对象来使用
                //         package中为了和java兼容默认不能声明属性和函数（方法）
                //         声明类是可以的
                //         scala提供了一种特殊的对象声明方式：包对象
                //         可以将一个包中共通性的方法或属性在包对象中声明
                val user03 = new User03
                println(user03)

                test()

            }
        }
    }
}