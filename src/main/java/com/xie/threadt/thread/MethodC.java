package com.xie.threadt.thread;


public class MethodC extends Thread{
    private ThreadA threadA;
    public MethodC(ThreadA threadA){
        this.threadA = threadA;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
            ThreadA.printC();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
