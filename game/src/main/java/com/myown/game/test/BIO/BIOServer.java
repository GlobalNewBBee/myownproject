package com.myown.game.test.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) {
        try {
            //创建一个服务端监听Socket
            ServerSocket serverSocket = new ServerSocket();
            //bind端口号
            serverSocket.bind(new InetSocketAddress("127.0.0.1",8888));
            System.out.println("开始监听端口号8888");

            while(true){
                //accept方法如果接收不到新的socket的话就会一直阻塞在那，除非有新的连接
                //accept方法不能放到Runnable任务中去，那么死循环就会一只创建线程，会造成内存空间不足
                Socket socket = serverSocket.accept();
                System.out.println(socket.getLocalPort());
                new Thread(()-> {
                    try {
                        byte[] bytes = new byte[1024];
                        InputStream in = socket.getInputStream();
                        int readLength = in.read(bytes);
                        if(readLength>0){
                            System.out.println("服务器收到请求信息："+new String(bytes,0,readLength));
                        }
                        OutputStream out = socket.getOutputStream();
                        out.write("服务器已收到请求".getBytes());
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
