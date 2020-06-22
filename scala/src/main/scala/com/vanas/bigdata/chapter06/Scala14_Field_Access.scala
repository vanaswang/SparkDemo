package com.vanas.bigdata.chapter06

import scala.beans.BeanProperty

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala14_Field_Access {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-访问权限
        //private :同类
        //如果属性声明为private，那么编译器生成set，get方法时，也会使用private进行修饰
        //使用@BeanProperty注解后，属性不能声明private
        val user = new User();
        user.test()

        //private[包名] ：同类，同包
        //中括号的包名可以向上使用
        //必须在当前包的作用域范围内

        //protected :同类、子类

        //（default）：公共的
        //scala中的源码文件中可以声明多个公共类
    }

    //内部类
    class User {
        //        @BeanProperty
        private var name: String = "zhangsan"
        private[chapter06] var age: Int = 20
        private[bigdata] var sex: String = "male"
        protected var tel: String = "123123"
        var email: String = "xxx@xxx.com"

        def test(): Unit = {
            println("name =" + name)
        }

    }

    class SubUser extends User {
        def testSub(): Unit = {
            println(this.tel)
        }
    }

    class Emp {
        def test(): Unit = {
            val user = new User
            //            user.name  用不了
            user.age
            user.sex
        }
    }


}

