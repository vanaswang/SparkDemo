package com.vanas.bigdata.test2


/**
 * @author Vanas
 * @create 2020-06-21 2:18 下午 
 */
class ArrayDemo {
    def main(args: Array[String]): Unit = {
        val arr1 = Array(30, 50, 70, 60, 10, 20) //arr1.:+(100)
        val arr2 = arr1 :+ 100
        println(arr2)
        val arr3 = 200 +: arr2 //arr2+:(200)
        println(arr3.mkString(","))

        val list1 = List(30, 50, 70, 60, 10, 20)

        println(100 :: (list1 :+ 10000))
        println(10 :: 20 :: 300 :: Nil)

    }
    /**
     * 运算的结合性
     * 左结合
     * 3+4
     * 右结合
     * 赋值运算都是右结合
     * 以冒号结尾的运算符都是右结合
     */
}
