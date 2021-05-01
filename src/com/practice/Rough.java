package com.practice;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Rough {

    public static void main(String[] args) {


        List<String> list = Arrays.asList(new String[]{"a", "b"});
        Stream<String> stream = list.stream().filter(a->a.equals("a"));
        List<String> st2 = stream.filter(a->a.equals("a")).collect(Collectors.toList());
        List<String> st3 = stream.filter(a->a.equals("a")).collect(Collectors.toList());
        ReentrantLock lock = new ReentrantLock();


        /*StaticTest staticTest = new StaticTest();
        System.out.println(StaticTest.str);
        staticTest.modify("abc");
        System.out.println(StaticTest.str);
        StaticTest.str = "def";
        System.out.println(StaticTest.str);*/

        Optional<String> optional = Optional.ofNullable("abc"=="def"?"abc":null);
        System.out.println(optional.isPresent());
        StaticTest staticTest = new StaticTest();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        
    }
}

class StaticTest {
    static String str;

    final public void modify(String str){
        StaticTest.str=str;
    }
}

interface Java8Interface{


    static public void tester(String s){

    }

}


