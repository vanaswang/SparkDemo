package com.vanas.bigdata.chapter10

/**
 * @author Vanas
 * @create 2020-05-30 3:30 下午 
 */
object Scala06_Transform {
//object Scala06_Transform extends Test {
    def main(args: Array[String]): Unit = {
        //隐式转换的查找规则
        //隐式类不能放置在顶级（top-level）对象中
        //1.当前代码的作用域中找到即可
        //2.当前代码上级作用域
        //3.当前类所在的包对象
        //4.当前类的父类或特质
        //如果想用隐式转换，那么直接导入
        import com.vanas.bigdata.chapter01.Scala06_ImplicitClass._

        val user = new User()
        user.insertUser()
        user.updataUser()
    }

//    implicit class UserExt07(user: User) {
//        def updataUser() = {
//            println("updata  07 user...")
//        }
//    }

    class User {
        def insertUser() = {
            println("insert user...")
        }
    }
}
//trait Test {
//    implicit class UserExt06(user: User) {
//        def updataUser() = {
//            println("updata 06 user...")
//        }
//    }
//}
//class Test {
//    implicit class UserExt06(user: User) {
//        def updataUser() = {
//            println("updata 06 user...")
//        }
//    }
//}
//implicit class UserExt(user:User) {
//    def updataUser() = {
//        println("updata user...")
//    }
//}
