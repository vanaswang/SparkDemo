package com.vanas.bigdata.java.chapter01;

import com.vanas.bigdata.chapter03.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Vanas
 * @create 2020-05-19 8:56 上午
 */
public class Test05_Net_Server2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        服务器 占用端口阻塞
        ServerSocket server = new ServerSocket(9999);
//

//        创建线程进行数据处理
        Socket client = server.accept();
//        input反序列化
        ObjectInputStream objInput = new ObjectInputStream(client.getInputStream());
        User05 user = (User05) objInput.readObject();

        System.out.println("服务器读取的用户数据为：" + user.name);
    }
}
