package com.xie.threadt.volatilet;

public class Test {
    public static void main(String[] args) {
        Aobing a = new Aobing();
        a.start();
        test(a);
    }

    public static synchronized void test(Aobing a){
        for(;;){
            if(a.isFlag()){
                System.out.println("有点东西。。。");
            }
        }
    }

}

class Aobing extends Thread {
    private /*volatile*/ boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public synchronized void setFlag(){
        flag = true;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setFlag();
        System.out.println("flag=" + flag);
    }
}
