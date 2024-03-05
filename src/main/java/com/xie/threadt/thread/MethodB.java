package com.xie.threadt.thread;


public class MethodB extends Thread{
    private ThreadA threadA;
    public MethodB(ThreadA threadA){
        this.threadA = threadA;
    }

    @Override
    public void run() {
        threadA.printB();
    }
}
