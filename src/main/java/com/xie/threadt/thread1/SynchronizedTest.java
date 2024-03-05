package com.xie.threadt.thread1;

public class SynchronizedTest {

    public static SynchronizedTest staticIn = new SynchronizedTest();   //静态对象

    public synchronized void method1(String threadName){                                      //非静态方法1
        for(int i = 0;i < 10;i++){
            System.out.println("method1 is running!" + threadName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized void method2(String threadName){                                   //非静态方法2
        for( int i = 0; i < 10 ; i++){
            System.out.println("method2 is running!" + threadName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized static void staticMethod1(String threadName){                     //静态方法1
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method1 is running!" + threadName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized static void staticMethod2(String threadName){                      //静态方法2
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method2 is running!" + threadName);

        }try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}