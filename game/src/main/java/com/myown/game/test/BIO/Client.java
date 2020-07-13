package com.myown.game.test.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            //获取到一个客户端的socket
            Socket socket = new Socket("127.0.0.1",8888);

            OutputStream out = socket.getOutputStream();
            out.write("hello and 你好".getBytes());

            System.out.println("消息发送完毕，等待服务端响应！");

            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int length = in.read(bytes);
            System.out.println("服务器响应结果："+new String(bytes,0,length));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
