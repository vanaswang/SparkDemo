package com.vanas.bigdata.chapter06

import scala.beans.BeanProperty

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala11_Field {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-属性

        //java Bean规范中，要求属性的set/get方法起名，必须以set，get开头
        //private String name
        //public void setName(String name){this.name =name}
        //public void getNmae(){return this.name}
        //框架 会动态获取属性，反射调用属性的get方法获取属性值

        //scala编译生成属性的set，get方法并没有遵循bean规范，这样在很多框架中无法使用
        //如果想要scala中的属性符合bean规范，可以采用特殊的注解 @BeanProperty

        val user = new User
        user.setName("xxx")
        user.getName()
        println(user.getName)
    }

    //内部类
    class User {
        //属性
        @BeanProperty
        var name: String = _
        @BeanProperty
        var age: Int = _
        @BeanProperty
        val sex: String = "男"

    }


}

