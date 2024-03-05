package com.xie.threadt.thread;

public class MethodA extends Thread{
    private ThreadA threadA;
    public MethodA(ThreadA threadA){
        this.threadA = threadA;
    }

    @Override
    public void run() {
        threadA.printA();
    }
}
