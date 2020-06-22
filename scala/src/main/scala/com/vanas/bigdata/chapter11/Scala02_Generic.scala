package com.vanas.bigdata.chapter11

/**
 * @author Vanas
 * @create 2020-06-01 8:52 上午 
 */
object Scala02_Generic {
    def main(args: Array[String]): Unit = {
        //看懂
        def f[A: Test](a: A) = println(a) //Test[a]
        //将泛型和隐式转换合二为一
        implicit val test: Test[User] = new Test[User]
        f(new User())
    }

    class Test[T] {
    }

    class Parent {
    }

    class User extends Parent {
    }

    class SubUser extends User {
    }

}
