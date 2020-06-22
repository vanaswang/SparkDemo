package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala22_Method_Instance {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-构造方法
        //如果父类有构造方法，怎么办？
        //Person =>User
        //new User()=new Person()
        //构建子类对象时，应该首先构建父类对象，如果父类的构造方法有参
        //那么子类在构建父类时也应该传递参数
        //scala中如何向父类的构造方法中穿参？
        //在父类名称的后面加括号就可以传参了
        val user = new User()
        val emp = new Emp("lisi")

    }

    class Person(name: String) {
        println("personname=" + name)

    }

    class User extends Person("zhangsan") {
        println("user....")
    }

    class Emp(name: String) extends Person(name) {
        println("emp...")

    }

}