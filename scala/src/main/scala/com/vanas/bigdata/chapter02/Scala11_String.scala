package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala11_String {
  def main(args: Array[String]): Unit = {
    //  字符串
    //    scala中没有字符串类型，它的字符串来自于Java
    //    String是不可变字符串
    val name: String = "zhangsan"
    val age: Int = 20
    val str: String = name.substring(0, 1)
    println(str)

    //  字符串拼接
    val hello = "hello" + name
    println(hello)
    println("name=" + name + "\tage=" + age)
    //    传值字符串
    printf("name = %s,age = %s", name, age)

    //    插值字符串 (前面加s 说明$是引用）
    println(s"name = $name,age = $age")

    //    JSON =》JavaScript Object Notation
    //    {"username":"zhangsan","age":20}
    //    JSON字符串，将对象转换为符合JSON个事的字符串
    //    相同类型的引号不能嵌套使用
    //    val json = "{\"username\":\"" + name + "\",\"age\":" + age + "}"
    //    println(json)

    //    多行字符串 """..."""
    //    竖线 表示顶格符
    val json =
    s"""
       |{"username":"$name","age":$age}
       |zhangsan
       |lisi
       |""".stripMargin
    println(json)

    val sql =
      s"""
         |select *
         |from user
         |where name =$name
         |""".stripMargin
    println(sql)
  }

}
