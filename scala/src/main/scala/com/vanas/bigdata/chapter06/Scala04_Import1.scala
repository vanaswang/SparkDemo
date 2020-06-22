package com.vanas.bigdata.chapter06


/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala04_Import1 {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-import

        //Scala中可以采用import关键字导入对象
        //导入对象只能对val声明的对象进行导入，var是不可以的
        Predef.println("zhangsan")
        val user = new User04()
        //var user = new Use04() //直接报错

        import user._ //对象名
        login()
        test4()
    }
}

class User04 {
    def test4(): Unit = {
        println("test...")
    }
    def login(): Unit ={
        println("login..")
    }
}
