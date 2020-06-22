package com.vanas.bigdata.test2

/**
 * @author Vanas
 * @create 2020-06-21 2:55 下午 
 */
object GenericDemo {

    case class Person(age: Int, name: String)

    implicit val ord: Ordering[Person] = new Ordering[Person] {
        override def compare(x: Person, y: Person): Int = x.age - y.age
    }

    def main(args: Array[String]): Unit = {
        foo[Int](10, 20)
        foo1[Int](10, 20)

        foo1(Person(10, "zs"), Person(20, "lisi"))
    }

    def foo[K](n1: K, n2: K)(implicit ord: Ordering[K]) = {
        println("foo[K]...")
        ord.max(n1, n2)
    }

    def foo1[K: Ordering](n1: K, n2: K) = {
        println("foo1[K:ordering]")
        //召唤隐式值
        val ord: Ordering[K] = implicitly[Ordering[K]]
        ord.max(n1, n2)
    }
    /*
    泛型上下文：
    [K:Ordering[K]
    表示必须存在隐式值：Ordering[K]
    其实是对隐式参数的一个简写
     */
}
