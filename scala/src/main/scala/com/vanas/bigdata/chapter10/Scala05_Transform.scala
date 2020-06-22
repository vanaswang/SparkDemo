package com.vanas.bigdata.chapter10

/**
 * @author Vanas
 * @create 2020-05-30 3:30 下午 
 */
object Scala05_Transform {
    def main(args: Array[String]): Unit = {
//        implicit def transform(user: User): UserExt = {
//            new UserExt
//        }

        val user = new User()
        user.insertUser()
        user.updataUser()
    }
    //隐式类
    //scala2.10版本中增加此功能
    //构造参数必须存在且只有一个，用于转换 类型
    //参数类型(User)=>当前类型（UserExt）
    implicit class UserExt(user:User) {
        def updataUser() = {
            println("updata user...")
        }
    }

    class User {
        def insertUser() = {
            println("insert user...")
        }
    }

}
