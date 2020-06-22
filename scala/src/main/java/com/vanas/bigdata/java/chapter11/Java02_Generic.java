package com.vanas.bigdata.java.chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vanas
 * @create 2020-06-01 8:53 上午
 */
public class Java02_Generic {
    public static void main(String[] args) {
        //泛型
        //泛型不可变
        //AAA<User>aaa1 =new AAA<Parent>();
        AAA<User> aaa2 = new AAA<User>();
        //AAA<User>aaa3 =new AAA<SubUser>();
        //AAA<User>aaa4 =new AAA<Emp>();
        System.out.println(aaa2);

        //泛型的上限，下限
        BBB bbb = new BBB();
        List<Parent> parentList = new ArrayList<Parent>();
        List<User> userList = new ArrayList<User>();
        List<SubUser> subUserList = new ArrayList<SubUser>();
        List<Emp> empList = new ArrayList<Emp>();
//        bbb.extendsTest(parentList); error
        bbb.extendsTest(userList);
        bbb.extendsTest(subUserList);
//        bbb.extendsTest(empList); error

        bbb.superTest(parentList);
        bbb.superTest(userList);
//        bbb.superTest(subUserList); error
//        bbb.superTest(empList);  error


        //泛型上限，下限使用的场景
        //泛型上限一般用于对获取的数据进行限定
        CCC<User> ccc = new CCC<User>();
        CCC<SubUser> ccc2 = new CCC<SubUser>();
        Message<? extends User> consume = ccc.consume();
        User t = consume.t;
        //泛型下限一般用于插入数据的类型限定
        DDD<User> ddd = new DDD<User>();
        ddd.producet(new Message<User>());
        ddd.producet(new Message<Parent>());
    }
}

class DDD<T> {
    public void producet(Message<? super T> m) {

    }
}

class Message<T> {
    public T t;
}

class CCC<T> {

    public Message<? extends T> consume() {
        return null;
    }
}

class BBB<T> {
    //泛型的上限
    public void extendsTest(List<? extends User> list) {

    }

    //泛型的下限
    public void superTest(List<? super User> list) {
    }
}

class AAA<T> {

}

class Parent {

}

class User extends Parent {

}

class SubUser extends User {

}

class Emp {

}