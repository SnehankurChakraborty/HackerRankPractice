package com.practice;

import java.util.Arrays;

public class ArrayRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i < d) {
                r[a.length - d + i] = a[i];
            } else {
                r[i - d] = a[i];
            }
        }
        return r;

    }

    public static void main(String[] args) {
        Arrays.stream(ArrayRotation.rotLeft(new int[]{1,2,3,4,5}, 4)).forEach(System.out::println);
    }
}
