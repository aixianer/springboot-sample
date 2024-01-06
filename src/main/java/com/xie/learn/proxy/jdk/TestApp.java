package com.xie.learn.proxy.jdk;

import com.xie.learn.proxy.Leader;
import com.xie.learn.proxy.inteface.IWork;

import java.lang.reflect.Proxy;

public class TestApp {
    public static void main(String[] args) {
        Leader leader = new Leader();
        IWork proxy = (IWork) Proxy.newProxyInstance(Leader.class.getClassLoader(),
                new Class[]{IWork.class}, new WorkInvocationHandler(leader));
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");
    }
}
