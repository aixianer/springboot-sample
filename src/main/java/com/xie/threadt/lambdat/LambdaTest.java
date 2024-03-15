package com.xie.threadt.lambdat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        //1、实现接口
        new Thread(() -> System.out.println("hello spring")).start();
        //2、操作字符串
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("p1",6);
        Person p2 = new Person("p2",5);
        Person p3 = new Person("p3",4);
        Person p4 = new Person("p4",1);
        Person p5 = new Person("p5",2);
        Person p6 = new Person("p6",3);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        List<Integer> ageList = list.stream().map(Person :: getAge).sorted(Comparator.reverseOrder()).limit(5).collect(Collectors.toList());
        System.out.println(ageList);
        List<Integer> ageList2 = list.stream().filter(person -> person.getAge() > 4).map(Person :: getAge).collect(Collectors.toList());
        System.out.println(ageList2);
        list.stream().map(Person :: getAge).sorted(Comparator.reverseOrder()).limit(5).forEach(System.out ::println);
    }
}
