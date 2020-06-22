package com.vanas.bigdata.chapter03

/**
 * @author Vanas
 * @create 2020-05-19 10:43 上午 
 */
object Scala05_Operator {
  def main(args: Array[String]): Unit = {
    //scala是一个完全面向对象的语言
    val user = new User()
//    user.++("+++++")
//    user.++("zhangsan")
    user ++ "zhangsan"
    user toString

    1.to(2)
    1 to 2

  }
}
