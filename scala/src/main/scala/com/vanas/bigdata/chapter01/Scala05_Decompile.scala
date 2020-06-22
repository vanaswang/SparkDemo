package com.vanas.bigdata.chapter01

/**
 *
 *使用object关键字声明类：
 * 1。编译时会产生2个类文件
 * 当前类名.class
 *  =》普通类+final
 * 当前类名$.class
 *  =》私有构造方法：静态属性= 当前对象
 *  =》静态返回本类型的属性
 *  =》静态代码块：创建当前类的对象 javap可以看到new
 *
 * =》
 * 在加载类的时候，创建类的实例并进行了赋值，形成了单例对象
 *
 * 2.当添加main方法时
 * 当前类名.class 会自动添加public static void main方法
 * 当前类名$.class 会自动添加 public void main 方法
 * 在静态的main方法中会调用类名$中的普通main方法
 *
 * 3.当添加打印语句时:
 * 当前类名$.class 会自动添加 打印语句
 *
 * 类名.class => static main =》 类名$.main =》println
 * @author Vanas
 * @create 2020-05-18 11:32 上午 
 */
object Scala05_Decompile {
//  如果想要scala执行，main方法是一个固定的写法
//  1。object类中声明
//  2。参数就一个，而且时Array[String]
//  3.无返回值Unit
  def main(args: Array[String]): Unit = {
    println("hello ");
  }
}
