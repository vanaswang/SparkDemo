package com.vanas.bigdata.chapter11

/**
 * @author Vanas
 * @create 2020-06-01 8:52 上午 
 */
object Scala01_Generic {
    def main(args: Array[String]): Unit = {
        //泛型
        //不要求自己写，能看懂就行
        //泛型一般在框架中使用，为了考虑通用性
        //默认Scala中的泛型和java是一致的
        //scala声明泛型，采用的中括号
        //泛型不可变
        //[T]
        //val a1: AAA[User] = new AAA[Parent] error
        val a2: AAA[User] = new AAA[User]
        //val a3: AAA[User] = new AAA[SubUser] error
        //al a4: AAA[User] = new AAA[Emp] error

        //泛型协变：将泛型作为类型的一部分来理解
        //泛型可以将子类型当成父类型使用
        //BBB[SubUser] 当成BBB[User]子类型
        //[+T]
        //val b1: BBB[User] = new BBB[Parent]
        val b2: BBB[User] = new BBB[User]
        val b3: BBB[User] = new BBB[SubUser]
        //val b4: BBB[User] = new BBB[Emp]

        //泛型逆变 ：将泛型作为类型的一部分来理解
        //泛型可以将父类型当成子类型使用
        //CCC[Parent]当作CCC[User]子类型
        //[-T]
        val c1: CCC[User] = new CCC[Parent]
        val c2: CCC[User] = new CCC[User]
        //val c3: CCC[User] = new CCC[SubUser]
        //val c4: CCC[User] = new CCC[Emp]

        //泛型上限
        //[>:]
        val ddd = new DDD()
        //ddd.test1[Emp](new Emp()) //error
        //ddd.test1[Parent](new Parent()) //error
        ddd.test1[User](new User())
        ddd.test1[SubUser](new SubUser())
        //泛型下限
        //[<:]
        //ddd.test2[Emp](new Emp()) //error
        ddd.test2[Parent](new Parent())
        ddd.test2[User](new User())
        //ddd.test2[SubUser](new SubUser()) //error

        //具体例子
        val list = List(1, 2, 3, 4)
        //将数据统计结果变为：1234
        //List（1，2，3，4） =>"1"+"2"+"3"+"4"="1234".toInt
        //A =>Int
        //A1 >:A =>AnyVal,Any
        //(A1,A1 )=>A1
        //val i: Int = list.reduce()
        val list1: List[Any] = "" +: list //
        val result: Any = list1.reduce(
            (x, y) => {
                x + y.toString
            }
        )
        println(result.toString.toInt)

        val strings: List[String] = list.map(num => num.toString)
        println(strings.reduce(_ + _).toInt)


        //fold方法要求数据处理类型和初始值的类型之间应该有关系
        val lon: AnyVal = 10
        val b: Long = 10
        //list.fold("")(_+_) //error  fold A1 A1 =>A1
//        val l: Long = list.fold(lon)(
//            (x, y) => {
//                x
//            }
//        )
//        list.fold(b) {
//            (x, y) => {
//                x
//            }
//        }

        //foldLeft数据处理类型和初始值的类型无关
        val str: String = list.foldLeft("")(_ + _)
        println(str.toInt)


        //两个map合并
        //map kv
        val map1 = Map("a" -> 1, "b" -> 2)
        val map2 = Map("a" -> 1, "b" -> 2)
        map1.fold(map2) {
            (map, kv) => {
                map
            }
        }

        map1.foldLeft(map2) {
            (map, kv) => {
                map
            }
        }

    }

    class DDD {
        //泛型上限(范围越来越小)
        def test1[T <: User](t: T) = {

        }

        //泛型下限(范围越来越大)
        def test2[T >: User](t: T) = {

        }
    }

    class CCC[-T] {

    }

    class BBB[+T] {

    }

    class AAA[T] {

    }

    class Parent {

    }

    class User extends Parent {

    }

    class SubUser extends User {

    }

    class Emp {

    }

}
