package com.xie.threadt.thread;

public class Main {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        new MethodC(threadA).start();
        new MethodA(threadA).start();
        new MethodB(threadA).start();
    }
}
