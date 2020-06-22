package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 10:51 上午 
 */
object Scala01_Object {

    def main(args: Array[String]): Unit = {
        //Scala - 面向对象
        //scala 的基本面向对象的语法和java是相同的

        /*
        Java ：
        package com.vanas.bigdata.xxx

        import java.util.*

        public class dept{
        }

        public class User{

            private String name;
            public void setName(String name){
                this.name = name
            }

            public String get Name(){
                return this.name;
            }
        }

         */

        val dept: Dept01 = new Dept01()
        val user: User01 = new User01()
        user.dept = dept
        user.name = "lisi"
        user.test()

        println(s"用户${user.name}所在的部门${user.dept.name}")

    }

}

class Dept01 {
    var name: String = "开发部门"
}

class User01 {
    var name: String = "zhangsan"
    var dept: Dept01 = null

    def test(): Unit = {
        println("user test ...")
    }
}
