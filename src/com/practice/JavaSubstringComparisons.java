package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * We define the following terms:
 * <p>
 * Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:
 * For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.
 * <p>
 * A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.
 * Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length .
 * <p>
 * Function Description
 * <p>
 * Complete the getSmallestAndLargest function in the editor below.
 * <p>
 * getSmallestAndLargest has the following parameters:
 * <p>
 * string s: a string
 * int k: the length of the substrings to find
 * Returns
 * <p>
 * string: the string ' + "\n" + ' where and are the two substrings
 * Input Format
 * <p>
 * The first line contains a string denoting .
 * The second line contains an integer denoting .
 * <p>
 * Constraints
 * <p>
 * consists of English alphabetic letters only (i.e., [a-zA-Z]).
 * Sample Input 0
 * <p>
 * welcometojava
 * 3
 * Sample Output 0
 * <p>
 * ava
 * wel
 * Explanation 0
 * <p>
 * String  has the following lexicographically-ordered substrings of length :
 * <p>
 * We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).
 * <p>
 * The stub code in the editor then prints ava as our first line of output and wel as our second line of output.
 */
public class JavaSubstringComparisons {
    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("Welcometojava", 3));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);


        /*List<String> subs = IntStream.range(0, s.length())
                .filter(i -> i + k < (s.length() + 1))
                .mapToObj(i -> s.substring(i, i + k))
                .sorted()
                .collect(Collectors.toList());*/


        for (int i = 0; i + k < s.length() + 1; i++) {
            if (s.substring(i, i + k).compareTo(largest) < 0) {
                largest = s.substring(i, i + k);
            }
            if (s.substring(i, i + k).compareTo(smallest) > 0) {
                smallest = s.substring(i, i + k);
            }
        }


        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }

}
