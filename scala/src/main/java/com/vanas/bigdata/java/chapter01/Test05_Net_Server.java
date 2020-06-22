package com.vanas.bigdata.java.chapter01;

import sun.jvm.hotspot.debugger.ThreadAccess;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Vanas
 * @create 2020-05-19 8:56 上午
 */
public class Test05_Net_Server {
    public static void main(String[] args) throws IOException {

//        服务器 占用端口阻塞
        ServerSocket server = new ServerSocket(9999);
//

//        创建线程进行数据处理
        while (true) {
            final Socket client = server.accept();
//            创建线程进行数据处理
            new Thread(
                    new Runnable() {
                        public void run() {
                            try {

                                int data = client.getInputStream().read();
                                System.out.println("服务器：" + data);
                            } catch (Exception e) {
                                e.printStackTrace();

                            }

                        }
                    }
            ).start();

        }
    }
}
