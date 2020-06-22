package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala15_Method {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-方法
        //所谓的方法就是类中声明的函数
        val user = new User

        //类中的方法：
        //1.默认方法
        //java.lang.Object的方法
        user.toString
        user.hashCode()
        //scala中提供的方法
        user.asInstanceOf[User]
        user.isInstanceOf[User]

        //获取对象的类型信息（方法去内存）
        //        val clazz: Class[_ <: User] = user.getClass
        val clazz: Class[User] = classOf[User]
//        println()
        // Predef中的方法

        //2.自定义方法

        //3.

    }

    class User {

        override def equals(obj: Any): Boolean = {
            //            if (obj instanOf User){
            //                User otherUser = (User)obj
            //            }
            if (obj.isInstanceOf[User]) {
                val otherUser = obj.asInstanceOf[User]
                this == otherUser
            } else {
                false
            }
        }
    }

}

