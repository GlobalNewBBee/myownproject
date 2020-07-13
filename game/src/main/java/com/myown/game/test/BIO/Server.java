package com.myown.game.test.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        //创建一个ServerSocket，监听8888端口
        try {
            ServerSocket sc = new ServerSocket();
            sc.bind(new InetSocketAddress("127.0.0.1",8888));

            while(true){
                //执行accept方法会一直阻塞在这里，直到有客户端想要连接服务端
                Socket socket = sc.accept();

                handle(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handle(Socket sc){

        //获取请求
        try {
            InputStream in = sc.getInputStream();
            byte[] bytes = new byte[1024];
            int length = in.read(bytes);
            System.out.println("客户端请求内容："+new String(bytes,0,length));

            //服务端响应
            OutputStream out = sc.getOutputStream();
            out.write("服务器已接收".getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
