package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala37_Interface {
    def main(args: Array[String]): Unit = {
        //Scala -特质-功能执行顺序
        //1.类混入多个特质的时候，功能执行顺序从右到左
        //2.特质中的super气质又特殊含义，表示的不是父特质，而是上级特质
        //3.如果想要改变执行顺序，需要指定特质的类型
        //向日志中向数据库中操作数据
        new MySQL37().operateData()
    }
}

trait Operate37 {
    def operateData(): Unit = {
        println("操作数据")
    }
}

trait DB37 extends Operate37 {
    override def operateData(): Unit = {
        print("向数据库中")
        super.operateData()
    }
}
trait Log37 extends Operate37 {
    override def operateData(): Unit = {
        print("向日志中")
        super[Operate37].operateData()//向日志中操作数据
    }
}

class MySQL37 extends DB37 with Log37 {

}