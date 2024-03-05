package com.xie.threadt.pool;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PoolTest {

    public void cacheThreadPoolTest() {
        ExecutorService executorService = Executors.newCachedThreadPool(new TestThreadPoolFactory("cachedThreadPool"));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("cachedThread");
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    public void fixedThreadPoolTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(5, new TestThreadPoolFactory("fixedThreadPool"));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                        System.out.println("fixedThreadPool");
                        System.out.println(Thread.currentThread().getName());
                    }
            );
        }
    }

    public void scheduleThreadPoolTest() {
        // 创建指定核心线程数，但最大线程数是Integer.MAX_VALUE的可定时执行或周期执行任务的线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5, new TestThreadPoolFactory("scheduledThread"));

        // 定时执行一次的任务，延迟1s后执行
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleThreadPool");
                System.out.println(Thread.currentThread().getName() + ", delay 1s");
            }
        }, 1, TimeUnit.SECONDS);

        // 周期性地执行任务，延迟2s后，每3s一次地周期性执行任务
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ", every 3s");
            }
        }, 2, 3, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleWithFixedDelay 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleWithFixedDelay执行花费时间=" + (end - start) / 1000 + "m");
                System.out.println("scheduleWithFixedDelay执行完成时间："
                        + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        }, 1, 2, TimeUnit.SECONDS);
    }
}
