package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala19_Collection_Method {
    def main(args: Array[String]): Unit = {

        //Scala-集合-常用方法-操作数据
        var list = List(1, 2, 3, 4, 5, 6)
        //yield

        //map:映射转换 A=>B
        //100%的需求会用到map
        def transform(i: Int): Int = {
            i * 2
        }

        //map方法可以将集合通过指定的转换规则变成新的集合
        //指定的转换规则会对集合的每一条数据起作用
        //        val newList: List[Int] = list.map(transform)
        //        val newList: List[Int] = list.map((i:Int)=>{i*2})
        //        val newList: List[Int] = list.map((i:Int)=>i*2)
        //        val newList: List[Int] = list.map((i)=>i*2)
        //        val newList: List[Int] = list.map(i=>i*2)
        val newList: List[Int] = list.map(_ * 2)
        println(newList)

        //扁平化
        //所谓的扁平化，其实就是将整体拆分成一个一个的个体使用的方法
        //扁平化操作默认只能对外层数据进行操作，内层的数据无法进行操作
        //1::list::Nil
        val list1 = List(
            List(
                List(1, 2)
            ), List(
                List(3, 4)
            )
        )
        println(list1.length) //2
        //1,2,3,4
        println(list1)
        println(list1.flatten)
        println(list1.flatten.flatten)

        //扁平映射 = 扁平化+映射
        val list2 = List(
            List(1, 2), List(3, 4)
        )
        println(list2.flatten.map(_ * 2))

        //方法中的参数表示集合中的每一个元素
        //方法返回的参数类型为可迭代的集合类型
        def transform1(list: List[Int]): List[Int] = {
            list.map(_ * 2)
        }

        //        println(list2.flatMap(transform1))
//                println(list2.flatMap((list)=>{list.map(_*2)}))
//                println(list2.flatMap(list=>list.map(_*2)))
                println(list2.flatMap(_.map(_*2)))


        val list3 = List("hello scala", "hello spark")

        //String
        //println(list3.flatten)  不符合想要的规则
        def transfrom2(s: String) = {
            s.split(" ").toList
        }
        println(list3.flatMap(transfrom2))
        println(list3.flatMap(_.split(" ")))

        //从原理上来讲，做不了扁平化
        val list5 = List(1, 2, 3, 4)
        println(list5.flatMap((num) => {
            List(num * 2)
        }))

        //过滤
        //按照指定的规则对集合中的每一条数据进行筛选过滤
        //满足条件的数据保留，不满足条件的数据丢弃
        val list6 = List(1,2,3,4)
        list6.filter((num)=>{num%2==0})

        val list7 = List("hello","spqrk","scala","hadoop")
        println(list7.filter(word => {
            word.startsWith("s")
        }))

        //分组
        //按照指定的规则对集合中的每一个数据进行分组
        //指定的规则其实是一个函数，这个函数的返回结果进行分组的key
        //分组后数据类型为Map
        //map中的key就是分组的key，value就是同一个组的数据集合
        val list8 =List(1,2,3,4)
        //1%2 =>1
        //2%2 =>0
        //3%2 =>1
        //4%2 =>0
        val map: Map[Int, List[Int]] = list8.groupBy(num => {
            num % 2
        })
        println(map)

        val list9 = List("hello","spqrk","hello","hadoop")
        println(list9.groupBy({
            word => {
                word
            }
        }))

        //排序
        //将集合中每一个数据按照指定规则进行排序
        //默认排序为升序
        //sortBy可以使用函数柯里化实现降序
        val list10 = List(3,1,4,2)
        println(list10.sortBy(num => num))
        println(list10.sortBy(num => -num)) //特定场合使用 比如数字
        println(list10.sortBy(num => num).reverse)
        println(list10.sortBy(num => num)(Ordering.Int.reverse))

        val list11 = List("1","2","11","4")
        //字符串的排序可以按照字典顺序
        println(list11.sortBy(s => s))
        //"1" =>1
        //"2" =>2
        //"11"=>11
        println(list11.sortBy(s => s.toInt))
        //自定义类型数据排序

        val user1 = new User()
        user1.name= "zhangsan"
        user1.age=20
        val user2 = new User()
        user2.name= "lisi"
        user2.age=10

        val user3 = new User()
        user3.name= "wangwu"
        user3.age=10

        val list12 = List(user1,user2,user3)

        //scala中的元组自动比较大小
        //先比较第一个元素，再比较第二个元素，以此类推
        println(list12.sortBy(user => {
            ( user.age,user.name)
        }))

    }
    class User{
        var name: String = _
        var age:Int =_

        override def toString: String = {
            s"User[$name,$age]"
        }
    }

}
