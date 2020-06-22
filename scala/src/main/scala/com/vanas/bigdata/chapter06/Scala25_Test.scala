package com.vanas.bigdata.chapter06
//使用2种或2种以上的方式构建对象
object Scala25_Test {
    def main(args: Array[String]): Unit = {
        //第一种构建对象:new
        val dept1 = new Dept03()
        //第二种构建对象:apply
        val dept2 = Dept03
        //第三种方式：反射
        val clazz: Class[Dept03] = classOf[Dept03]
        val dept3: Dept03 = clazz.newInstance()
        //第四种方式：clone
//        dept3.clone()

        //第五种方式：反序列化

    }

}

class Dept03 {
    def this(name: String) {
        this()

    }

    def this(name: String, age: Int) {
        this()
    }
    //将多个子类的共通方法抽出来到父类中
    protected def getDeptName(): String={
        return "xxxxx"
    }


}

object Dept03 {
    def apply(): Dept03 = new Dept03()
}
class SubDept1 extends Dept03{
//    def getDeptName(): String={
//        return "xxxxx"
//    }
}
class SubDept2 extends Dept03{
//    def getDeptName(): String={
//        return "xxxxx"
//    }

}

