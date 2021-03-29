package com.practice;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Rough {

    public static void main(String[] args) {


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


