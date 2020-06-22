package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala05_Function {

    def main(args: Array[String]): Unit = {
        //函数参数的个数
        //        函数的参数不要无限多，最大个数为22,声明时候可以超过22
        //        但是将函数作为对象赋值给变量时会报错
        //        val a:Func
        def test(
                        i1: Int,
                        i2: Int,
                        i3: Int,
                        i4: Int,
                        i5: Int,
                        i6: Int,
                        i7: Int,
                        i8: Int,
                        i9: Int,
                        i10: Int,
                        i11: Int,
                        i12: Int,
                        i13: Int,
                        i14: Int,
                        i15: Int,
                        i16: Int,
                        i17: Int,
                        i18: Int,
                        i19: Int,
                        i20: Int,
                        i21: Int,
                        i22: Int
                ): Unit = {

        }

        val a = test _
        println(a)

        //        可变参数，相同类型的参数多次出现，但是不确定个数
        //java=>String..
        //scala =>String*
        def test1(i: Int*): Unit = {
            println(i)
        }

        test1()
        test1(1)
        test1(1, 2, 3)

        //可变参数的顺序:放置在最后
        def test2(age: String, i: Int*): Unit = {

        }

        test2("", 2, 3, 4, 20)

        //        同一个参数列表中只能有一个可变参数
        //        def test3(name:String*,age:Int*): Unit ={
        //
        //        }

        //      scala中函数的参数使用val声明，无法进行修改
        //        scala提供了参数默认值饿语法来解决参数默认值的问题
        //        def regUser(name: String, password: String): Unit = {
        //            var pswd = ""
        //            if (password == null) {
        //                password = "000000"
        //            }
        //        }
        //        regUser("张三", null)

        //        参数默认值（初始）：参数声明时进行初始化
        def regUser(name: String, password: String = "000000"): Unit = {
            println("password=" + password)
        }
        //        如果函数存在默认值参数，调用时可以不用传递,不传参数，会使用默认值
        //
        regUser("zhangsan")
        //        如果调用函数时，提供了参数值那么默认值不起作用，被覆盖了
        regUser("lisi", "123123")


        def regUse1r(name: String, password: String = "000000", tel: String): Unit = {
            println("name="+name+",password=" + password + ",tel=" + tel)
        }

//        函数在传递参数时，是按照从左到右的方式进行匹配的
//        regUse1r("vanas","123144")
        regUse1r("vanas","123144","1234444")
//        带名参数：传递参数时添加参数名，明确指定参数
        regUse1r("张三",tel = "123124134")
    }


}
