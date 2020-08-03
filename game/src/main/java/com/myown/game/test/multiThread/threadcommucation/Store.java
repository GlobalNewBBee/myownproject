package com.myown.game.test.multiThread.threadcommucation;

import java.util.concurrent.ExecutionException;

public class Store {

    private static Integer count = 0;

    /*
    * 商店的进货方法
    * */
    public synchronized void produce(){
        //第一版：如果使用if来判断条件，可能会出现生产者或者消费者线程执行完成，另一个永远不会被唤醒的情况
        /*if(count<=0){
            count++;
            System.out.println(Thread.currentThread().getName()+"进货，商店商品库存："+count);
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        if(count>0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            count++;
            System.out.println(Thread.currentThread().getName()+"开始生产，商店商品库存："+count);
            notifyAll();
        }
        /*while(count>0){
            try{
                wait();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"进货，商店商品库存："+count);
        notifyAll();*/
    }

    /*
    * 商店的卖货方法
    * */
    public synchronized void consume(){
        //第一版：如果使用if来判断条件，可能会出现生产者或者消费者线程执行完成，另一个永远不会被唤醒的情况
        /*if(count>0){
            count--;
            System.out.println(Thread.currentThread().getName()+"消费了一件商品，商品库存："+count);
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        if(count<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            count--;
            System.out.println(Thread.currentThread().getName()+"消费了一件商品，商品库存："+count);
            notifyAll();
        }
        /*while(count<=0){
            try{
                wait();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"消费了一件商品，商品库存："+count);
        notifyAll();*/
    }
}
