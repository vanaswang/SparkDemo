package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala10_Field {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-属性
        //class可以声明在其他的地方

        val user = new User()
        user.name="lisi"
        println(user.name)
//        user.name.=("lisi") //error
//        user.name_=("lisi")
        user.name_$eq("wu") //底层把= 转换为$eq
        println(user.name)
        //scala类中声明的属性，不仅仅只有属性，还有其他的内容
        //1.编译时，类中声明的属性，其实都是private，并同时提供了公共方法进行访问
        //2.编译生成的方法为：
        //类似于java中bean对象的get方法，用于返回属性的值
        //  public String name() {return this.name;}
        //类似于java中bean对象的set方法，用于设定属性的值
        //  public void name_$eq(final String x$1) {this.name = x$1;}
        //3.在使用时属性
        //因为属性为私有的，所以给属性赋值，其实等同于调用set方法
        //因为属性为私有的，所以获取属性值，其实等同于调用get方法
        //4.使用val声明的属性
        //在编译时，属性会被直接使用final修饰
        //在使用的过程中，也不提供属性的set方法
    }

    //内部类
    class User {
        //属性
        var name: String = _
        var age: Int = _
        val sex: String = "男"

    }


}

