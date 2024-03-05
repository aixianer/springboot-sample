package com.xie.threadt.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        System.out.println(i + 1 + "进行中");
                    }
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "我被调用";
            }
        };
        FutureTask<String> future = new FutureTask<String>(call);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
