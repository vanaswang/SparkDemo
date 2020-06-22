package com.vanas.bigdata.java.chapter06;

import com.apple.eawt.AppEvent;

/**
 * @author Vanas
 * @create 2020-05-23 11:34 上午
 */
public class Java03_Static {
    //
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread();

        t1.start();
        t2.start();

        //核心区别：字体上
        //静态的方法在Idea中默认就是斜体的
        //静态的方法和类型相关，和对象无关
        //sleep方法和t1无关，就不可能让t1休眠，让当前正在执行的线程（main）休眠
        //sleep无法释放对象锁 因为没有锁
        t1.sleep(1000);
        //成员的方法在Idea中默认就不是斜体的
        //成员方法和对象相关
        //wait方法和t2相关，所以会让t2等待
        //wait可以释放对象锁
        synchronized (t2){
            t2.wait();
        }

    }
}
