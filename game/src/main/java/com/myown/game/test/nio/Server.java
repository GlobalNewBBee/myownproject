package com.myown.game.test.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Server {

    public static void main(String[] args) {
        try {
            //创建一个服务端监听通道
            ServerSocketChannel scchannel = ServerSocketChannel.open();
            System.out.println("scchannel的地址信息："+scchannel.getLocalAddress());
            //开启一个Selector
            Selector selector = Selector.open();
            scchannel.configureBlocking(false);
            SelectionKey selectionKey = scchannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_ACCEPT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);

            int interestOps = selectionKey.interestOps();
            System.out.println("Selector 感兴趣的事件："+interestOps);
            while(interestOps>0){

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
