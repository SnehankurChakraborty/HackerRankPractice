package com.practice;

import java.util.*;

public class StackTest {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            String[] elements = input.split("");
            Map<String, String> keyMap = new HashMap<>();
            keyMap.put("{","}");
            keyMap.put("[","]");
            keyMap.put("(",")");
            Stack<String> stack = new Stack<>();
            for (String elem : elements) {
                if (stack.isEmpty()) {
                    stack.push(elem);
                } else {
                    if (keyMap.containsKey(stack.peek()) && keyMap.get(stack.peek()).equals(elem)) {
                        stack.pop();
                    } else {
                        stack.push(elem);
                    }
                }
            }
            stack.stream().forEach(System.out::println);
            System.out.println("Perfectly Balanced -> " + stack.isEmpty());
        }

    }
}
