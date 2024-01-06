package com.xie.learn.proxy.cglib;

import com.xie.learn.proxy.Leader;
import net.sf.cglib.proxy.Enhancer;

public class TestApp {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer(); // 通过CGLIB动态代理获取代理对象的过程
        enhancer.setSuperclass(Leader.class); // 设置enhancer对象的父类
        enhancer.setCallback(new LeaderMethodInterceptor()); // 设置enhancer的回调对象
        Leader proxy= (Leader)enhancer.create(); // 创建代理对象
        // 通过代理对象调用目标方法
        proxy.meeting();
        proxy.evaluate("Joy");
        proxy.evaluate("James");
    }
}
