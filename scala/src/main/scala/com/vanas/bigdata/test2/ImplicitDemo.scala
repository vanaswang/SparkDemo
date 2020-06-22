package com.vanas.bigdata.test2

import java.time.LocalDate

/**
 * @author Vanas
 * @create 2020-06-21 1:57 下午 
 */
object ImplicitDemo {
    def main(args: Array[String]): Unit = {
        //1.days(ago)
        val ago = "ago"
        val later = "later"
        val r1 = 10 days ago
        val r2 = 2 days later

        println(r1) //2020-06-11
        println(r2) //2020-06-23
    }

    implicit class RichInt(day: Int) {
        def days(when: String) = {

            when match {
                case "ago" =>
                    LocalDate.now().plusDays(-day).toString
                case "later" =>
                    LocalDate.now().plusDays(day).toString
                case _ =>
                    ""
            }
        }
    }
}
