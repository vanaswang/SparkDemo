package com.vanas.bigdata.chapter12

import scala.util.matching.Regex

/**
 * @author Vanas
 * @create 2020-06-01 10:41 上午 
 */
object Scala01_Regex {
    def main(args: Array[String]): Unit = {
        //正则表达式
        //类似于模式匹配
        //模式匹配是对数据进行匹配
        //正则表达式对字符串的内容进行匹配
        //有自己的匹配规则

        //声明规则
        val r: Regex = "s".r
        val r1: Regex = "s$".r

        //使用规则
        val s = "hello hive"
        r findFirstIn s
        val maybeString: Option[String] = r.findFirstIn(s)
        //r.findAllIn(s)
        //r.findAllMatchIn(s)
        if (maybeString.isEmpty){
            println("没有符合规则的内容")
        }else{
            println(maybeString.get)
        }
        //判断字符串是不是一个电话号码
        //1.全部都是数字
        //2.数字长度11位
        val r2: Regex = "^\\d{11}$".r
        val s1 = "01514021200"
        val maybeString1: Option[String] = r2.findFirstIn(s1)
        if (maybeString1.isEmpty){
            println("没有符合规则的内容")
        }else{
            println(maybeString1.get)
        }
    }
}
