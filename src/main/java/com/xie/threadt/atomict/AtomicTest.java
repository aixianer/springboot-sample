package com.xie.threadt.atomict;

public class AtomicTest {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        // 多个线程并发地增加计数器的值
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter=counter+1;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter=counter+1;
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Counter value: " + counter);
    }
}
