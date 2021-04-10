package com.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Altimetrik {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 17, 13, 4, 18);
        System.out.println(intList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(2));

        List<String> fruitsList = Arrays.asList("Apple", "Apple", "Apple", "Apple", "Orange",
                "Orange", "Orange", "Orange", "Mango", "Mango", "Banana");
        Map<String, Long> fruitsMap = new TreeMap<>();
        /*fruitsList.forEach(fruit -> {
            if (!fruitsMap.containsKey(fruit)) {
                fruitsMap.put(fruit, fruitsList.stream().filter(fruitName -> fruitName.equalsIgnoreCase(fruit)).count());
            }
        });*/
        /*fruitsMap.keySet().stream().sorted(Comparator.reverseOrder())
                .forEach(key -> System.out.println("Key -> " + key + " Value->" + fruitsMap.get(key)));
*/
        /*fruitsMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> System.out.println("Key -> " + entry.getKey() + " Value->" + entry.getValue()));*/

        /*fruitsMap.values().stream().sorted(Comparator.reverseOrder())
                .forEach(value -> System.out.println("Key -> " + fruitsMap.keySet().stream()
                        .filter(key -> fruitsMap.get(key).equals(value)).collect(Collectors.toList()).get(0)
                        + " Value->" + value));*/

        fruitsList.stream()
                .collect(Collectors.toMap(Function.identity(), f -> Collections.frequency(fruitsList, f), (key1, key2) -> key1))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " ->" + entry.getValue()));

        fruitsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> System.out.println(entry.getKey() + " ->" + entry.getValue()));
    }


}
