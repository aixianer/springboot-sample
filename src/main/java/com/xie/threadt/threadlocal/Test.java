package com.xie.threadt.threadlocal;

public class Test {
    private static  ThreadLocal<String> str = new ThreadLocal<>();

    public static void main(String[] args) {
        str.set("xxxxxx");
        String s = str.get();
        System.out.println(s);
    }
}
