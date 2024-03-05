package com.xie.threadt.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPoolFactory  implements ThreadFactory {
    private AtomicInteger threadIdx = new AtomicInteger(0);
    private String threadNamePrefix;

    public TestThreadPoolFactory(String threadNamePrefix){
        this.threadNamePrefix = threadNamePrefix;
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(threadNamePrefix + "-xxljob-" + threadIdx.getAndIncrement());
        return thread;
    }
}
