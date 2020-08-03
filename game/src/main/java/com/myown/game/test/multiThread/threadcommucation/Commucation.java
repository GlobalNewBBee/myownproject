package com.myown.game.test.multiThread.threadcommucation;

public class Commucation {

    public static void main(String[] args) {

        //资源类
        Store store = new Store();

        new Thread(()->{
            for(int i=0;i<10;i++){
                store.produce();
            }
        },"商店老板").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                store.consume();
            }
        },"消费者").start();
    }
}
