package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala21_Method_Instance {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-构造顺序
        val user = new User("zhangsan", 30)
        //AAAA
        //BBBB
        //CCCC
        //如果在类名的后面增加privat关键字，表示主构造方法私有化，无法在外部使用
        val user1 = new User()

    }

    class User(name: String) {
        println("AAAAA")

        def this() {
            this("zhangsan")
            println("BBBB")
        }

        def this(name: String, age: Int) {
            this()
            println("CCCCCC")
        }
    }

}