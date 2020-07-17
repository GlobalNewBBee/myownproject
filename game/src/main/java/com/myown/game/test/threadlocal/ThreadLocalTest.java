package com.myown.game.test.threadlocal;

import com.google.common.collect.Lists;

import java.util.List;

public class ThreadLocalTest {
    private List<String> messages = Lists.newArrayList();
    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = holder.get().messages;
        holder.remove();
        System.out.println("size: " + holder.get().messages.size());
        //这里仍然会打印字符串"一枝花算不算浪漫"，因为ThreadLocalMap的Entry的value存放的只是引用，remove也只是将这个value置为了null，这个ArrayList对象还是存在的
        System.out.println(messages);
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("一枝花算不算浪漫");
        System.out.println(holder.get().messages);
        List<String> clear = ThreadLocalTest.clear();
        System.out.println(clear);
    }
}