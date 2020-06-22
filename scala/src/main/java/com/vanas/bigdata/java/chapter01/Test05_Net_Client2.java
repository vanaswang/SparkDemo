package com.vanas.bigdata.java.chapter01;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Vanas
 * @create 2020-05-19 8:56 上午
 */
public class Test05_Net_Client2 {
    public static void main(String[] args) throws IOException {

//        客户端
        Socket socket = new Socket("localhost", 9999);
//        输出
        User05 user = new User05();
        user.name = "zhangsan";
//        序列化对象
        ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
        objOut.writeObject(user);
        System.out.println("客户端发送对象数据");
        socket.close();

    }
}
