package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala20_Method_Instance {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-构造方法
        //给构造方法增加参数的目的是什么？
        //从外部将数据传递到对象的属性中
        //java:public User(String name){ this.username=name}

        //scala中一般构造方法的参数用于属性的初始化，所以为了减少数据的冗余
        //可以使用关键字var，val 将构造参数当成类的属性来用
        //var可读可写 ，val可读不可写
        val user = new User("zhangsan")
        println(user.username)
//        println(user.name)

        val emp = new Emp("lisi")
        println(emp.name)

    }

    class User(name: String) {
        //name其实是函数的参数，局部变量,无法通过对象在外部访问
        //username 其实是类的属性，但也是局部变量，可以通过对象在外部访问
        val username: String = name

    }
    class Emp(val name :String){

    }

}