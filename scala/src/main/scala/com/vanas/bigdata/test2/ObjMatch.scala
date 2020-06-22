package com.vanas.bigdata.test2


/**
 * @author Vanas
 * @create 2020-06-21 2:32 下午 
 */
object ObjMatch {
    def main(args: Array[String]): Unit = {
        val d = 9.0
        d match {
            case Sqrt(r) =>
                println(r)
        }
    }

    val user = new User("zs", 10)
    user match {
        case User(n, a) => {
            println(n)
            println(a)
        }
    }
}

object Sqrt {
    def unapply(n: Double): Option[Double] = if (n >= 0) Some(math.sqrt(n)) else None
}

object User {
    def unapply(user: User): Option[(String, Int)] = if (user == null) None else Some((user.name, user.age))
}

case class User(val name: String, val age: Int)