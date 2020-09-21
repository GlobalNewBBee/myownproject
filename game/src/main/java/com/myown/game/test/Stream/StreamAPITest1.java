package com.myown.game.test.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
* Stream的创建方式
* */
public class StreamAPITest1 {

    public static void main(String[] args) {
        test04();

    }

    //1.创建Stream的方式一：通过集合
    public void test01(){
        List list = new ArrayList<>();
        for (int i=0;i<5;i++){
            list.add(i);
        }
        //default Stream stream()：返回一个顺序流
        Stream stream = list.stream();
        //default Stream parallelStream()： 返回一个并行流
        Stream parallelStream = list.parallelStream();
    }

    //2.创建Stream的方式二：通过数组
    public void test02(){
        Integer[] arr = new Integer[]{1,2,3,4,5};
        //调用Arrays类的static<T> Stream<T> stream(T[] array)
        Stream<Integer> integerStream = Arrays.stream(arr);
    }

    //3.创建Stream的方式三：通过Stream的of()方法
    public void test03(){
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5);
    }

    //4.创建Stream的方式四：创建无限流
    public static void test04(){
        //迭代
        //public static Stream<T> iterate(fianl T seed, final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        //public static Stream<T> generator(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
