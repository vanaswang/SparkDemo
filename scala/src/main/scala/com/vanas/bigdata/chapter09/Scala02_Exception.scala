package com.vanas.bigdata.chapter09

/**
 * @author Vanas
 * @create 2020-05-30 2:52 下午 
 */
object Scala02_Exception {
    def main(args: Array[String]): Unit = {
        //scala中的异常和java的异常处理很相似

    }
}
class Dept{
    @throws[Exception]
    def test()={
        throw new Exception
    }
}
