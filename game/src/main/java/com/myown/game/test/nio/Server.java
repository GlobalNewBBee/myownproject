package com.myown.game.test.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try{
            //创建一个用来监听端口的ServerSocketChannel
            ServerSocketChannel scchannel = ServerSocketChannel.open();
            scchannel.bind(new InetSocketAddress("127.0.0.1",8888));
            scchannel.configureBlocking(false);
            //创建一个Selector多路复用器
            Selector selector = Selector.open();
            //将通道注册到Selector
            SelectionKey key = scchannel.register(selector, SelectionKey.OP_ACCEPT);

            int interest = key.interestOps();
            System.out.println("服务端感兴趣的事件："+interest);

            int ready = key.readyOps();
            System.out.println("服务端已经就绪的事件："+ready);

            //分配缓冲区
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

            while(true){
                //执行select方法就会阻塞直到有事件就绪
                int readyNum = selector.select();
                //System.out.println("已经被select的个数："+readyNum);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while(iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    if(selectionKey.isAcceptable()){
                        SocketChannel schannel = scchannel.accept();
                        schannel.configureBlocking(false);
                        schannel.register(selector,SelectionKey.OP_READ);
                        System.out.println("通道已经读就绪了");
                    }else if(selectionKey.isReadable()){
                        SocketChannel channel1 = (SocketChannel) selectionKey.channel();
                        readBuffer.clear();
                        channel1.read(readBuffer);

                        readBuffer.flip();
                        System.out.println("服务器收到的信息："+new String(readBuffer.array())+",并且已经写就绪了");

                        selectionKey.interestOps(SelectionKey.OP_WRITE);
                    }else if(selectionKey.isWritable()){
                        writeBuffer.clear();
                        SocketChannel channel2 = (SocketChannel)selectionKey.channel();
                        writeBuffer.put("你瞅啥，瞅你咋地，你再瞅试试".getBytes());
                        //此时location指向了下一个可以写入的位置，limit等于capacity-1，要想可以
                        //写数据出去需要将limit=location，location=0，即执行flip方法
                        writeBuffer.flip();
                        channel2.write(writeBuffer);
                        selectionKey.interestOps(SelectionKey.OP_READ);
                        System.out.println("通道已经重新读就绪了");
                    }
                    iterator.remove();
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
