package com.xie.threadt.thread1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest test1 = SynchronizedTest.staticIn;
        SynchronizedTest test2 = new SynchronizedTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test1.staticMethod1("aaaa");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test2.staticMethod2("bbbbb");
            }
        });
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1000);
        service.execute(t1);
        service.execute(t2);
        service.shutdown();
    }
}
