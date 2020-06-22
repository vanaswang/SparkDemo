package com.vanas.bigdata.java.chapter01;

        import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;

/**
 * @author Vanas
 * @create 2020-05-19 8:56 上午
 */
public class Test05_Net_Client {
    public static void main(String[] args) throws IOException {

//        客户端
        Socket socket = new Socket("localhost", 9999);
//        输出
        socket.getOutputStream().write(10);
        System.out .println("客户端发送的数据为10");
        socket.close();

    }
}
