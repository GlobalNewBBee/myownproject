package com.myown.game.test.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client2 {
    public static void main(String[] args) {
        try{
            //创建一条通道
            SocketChannel schannel = SocketChannel.open();
            schannel.connect(new InetSocketAddress("127.0.0.1",8888));

            ByteBuffer readBuffer = ByteBuffer.allocate(32);
            ByteBuffer writeBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("Client2:你再瞅一个试试".getBytes());
            writeBuffer.flip();

            int count = 1;
            while(true){
                System.out.println("==================第"+count+"次 开始==========");
                Thread.sleep(2000);
                writeBuffer.rewind();
                schannel.write(writeBuffer);

                readBuffer.clear();
                schannel.read(readBuffer);
                System.out.println("Client接收到服务端的消息："+new String(readBuffer.array()));
                System.out.println("==================第"+count+"次 结束==========");
                count++;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
