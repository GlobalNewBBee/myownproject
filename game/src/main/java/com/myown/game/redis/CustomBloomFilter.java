package com.myown.game.redis;

import io.swagger.models.auth.In;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;

/*
* 自定义的布隆过滤器
* */
public class CustomBloomFilter {

    private static final int DEFAULT_SIZE = 256<<22;

    private static BitSet bitmap = new BitSet(DEFAULT_SIZE);

    private static final int[] seeds = {5,7,11};

    private static Function[] functions = new Function[seeds.length];

    /*
    * 静态代码块，在类加载的时候创建hash函数
    * */
    static{
        for(int i = 0;i<functions.length;i++){
            functions[i] = new Function(DEFAULT_SIZE,seeds[i]);
        }
    }

    /*
    * 判断当前这个key在不在这个布隆过滤器的位图中
    * */
    public static boolean hasKey(String key){
        boolean exist = true;
        if(key==null){
            System.out.println("请重传！");
            return false;
        }
        for(int i=0;i<functions.length;i++){
            Integer location = functions[i].hash(key);
            exist = bitmap.get(location);
            if(!exist){
                break;
            }
        }
        return exist;
    }

    /*
    * 给布隆过滤器添加key
    * */
    public static void addKey(String key){
        if(key==null){
            System.out.println("请重传！");
        }
        for(int i = 0;i<functions.length;i++){
            Integer hash = functions[i].hash(key);
            bitmap.set(hash,true);
        }
    }

    //Hash函数类
    private static class Function{

        //bitset的长度,必须是2的n次方
        private Integer size;
        //为了让每个hash函数计算出来的结果都不一样，就需要这个种子seed
        private Integer seed;

        public Function(int size,int seed){
            this.seed = seed;
            this.size = size;
        }

        //hash函数参考Hashmap的hash函数
        public Integer hash(String key){
            int hashcode;
            hashcode = (key==null)? 0 :(key.hashCode() ^ seed.hashCode());
            return hashcode & (this.size-1);
        }
    }

    public static void main(String[] args) {

        /*ThreadLocal threadLocal = new ThreadLocal(){
            @Override
            protected Object initialValue() {
                return "笨猪";
            }
        };
        Object result = threadLocal.get();
        System.out.println("result:"+result);*/
        for(int i=0;i<10000;i++){
            addKey(((Integer) i).toString());
        }
        System.out.println((hasKey(((Integer) 9999).toString()))?"true":"false");
        /*AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger);*/
    }
}
