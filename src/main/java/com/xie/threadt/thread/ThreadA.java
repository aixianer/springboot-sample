package com.xie.threadt.thread;

public class ThreadA {

    public synchronized static void  printA() {
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method2 is running!aaaaaaaaaaaaaaaaaaaaaaaaa");

        }try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized static void  printB() {
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method2 is running!bbbbbbbbbbbbbbbbbbbbbbbb");

        }try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized static void  printC() {
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method2 is running!ccccccccccccccccccccc");

        }try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
