package com.myown.game.test.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/*
* 测试Stream的中间操作
* */
public class StreamAPITest2 {

    public static void main(String[] args) {
        //System.out.println(Double.doubleToLongBits(12));
        //test02();
        String temp = "ajghaagie<username>sjsjnl</username>hahah";
        int index1 = temp.indexOf("<");
        int index2 = temp.indexOf("</username>");
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(temp.substring(0,index1));
        System.out.println(temp.substring(0,index2));
    }

    /*
    * 筛选和切片
    * */
    public static void test01(){
        Collection<Employee> list = CollectionUtils.getCollection();

        //过滤 filter(Predicate p) 接受lambda
        //练习：查询员工集合中薪资大7000的员工的信息
        list.stream().filter(e->e.getSalary()>7000).forEach(System.out::println);

        System.out.println();

        //limit(n),使其元素个数不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();

        //skip(n) 返回一个扔掉前n个元素的流。若流中元素不足n个，则返回一个空流.
        list.stream().skip(3).forEach(System.out::println);

        System.out.println();

        //distinct() 根据流中元素的hashCode()和equals()方法去重
        list.add(new Employee(1008,"刘强东",46,8000));
        list.add(new Employee(1008,"刘强东",46,8000));
        list.add(new Employee(1008,"刘强东",46,8000));
        list.add(new Employee(1008,"刘强东",46,8000));
        list.stream().distinct().forEach(System.out::println);
    }

    /*
    * 映射
    * */
    public static void test02(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        //map(Function f)接收一个函数作为参数,这个函数会作用在每一个元素上
        list.stream().map(e->e.toUpperCase()).forEach(System.out::println);

        //练习1：获取员工姓名长度大于3的员工的姓名
        Collection<Employee> collection = CollectionUtils.getCollection();
        collection.stream().map(e->e.getName()).filter(e->e.length()>=3).forEach(System.out::println);

        System.out.println();

        //flatMap(Function f)--接受一个函数作为参数,将流中的每一个值都换成另一个流,然后将所有的流连成一个流
        //练习2：
        Stream<Stream<Character>> characterStream = list.stream().map(StreamAPITest2::strToStream);
        characterStream.forEach(s->s.forEach(System.out::println));
        System.out.println();
        Stream<Character> characterStream1 = list.stream().flatMap(StreamAPITest2::strToStream);
        characterStream1.forEach(System.out::println);
    }

    public static Stream<Character> strToStream(String str){
        ArrayList list = new ArrayList();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    /*
    * 排序
    * */
    public void test03(){
        Collection employees = CollectionUtils.getCollection();
    }
}
