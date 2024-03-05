package com.xie.threadt.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>(500);
        Map<String, String> hashMap = new HashMap<>(500);

        // 创建两个线程并启动它们
        Thread thread1 = new Thread(() -> {
            for (int index1 = 0; index1 < 1000; index1++) {
                concurrentHashMap.put(Integer.toString(index1), Integer.toBinaryString(index1));

                hashMap.put(Integer.toString(index1), Integer.toBinaryString(index1));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int index2 = 1000; index2 < 2000; index2++) {
                concurrentHashMap.put(Integer.toString(index2), Integer.toBinaryString(index2));

                hashMap.put(Integer.toString(index2), Integer.toBinaryString(index2));
            }
        });

        thread1.start();
        thread2.start();

        // 等待两个线程结束
        thread1.join();
        thread2.join();

        System.out.println("ConcurrentHashMap size: " + concurrentHashMap.size());
        System.out.println("HashMap size: " + hashMap.size());
    }
}
