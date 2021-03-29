package com.practice;


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
 * <p>
 * Function Description
 * <p>
 * Complete the isAnagram function in the editor.
 * <p>
 * isAnagram has the following parameters:
 * <p>
 * string a: the first string
 * string b: the second string
 * Returns
 * <p>
 * boolean: If  and  are case-insensitive anagrams, return true. Otherwise, return false.
 * Input Format
 * <p>
 * The first line contains a string .
 * The second line contains a string .
 * <p>
 * Constraints
 * <p>
 * Strings  and  consist of English alphabetic characters.
 * The comparison should NOT be case sensitive.
 * Sample Input 0
 * <p>
 * anagram
 * margana
 * Sample Output 0
 * <p>
 * Anagrams
 * Explanation 0
 * <p>
 * Character	Frequency: anagram	Frequency: margana
 * A or a	3	3
 * G or g	1	1
 * N or n	1	1
 * M or m	1	1
 * R or r	1	1
 * The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
 * <p>
 * Sample Input 1
 * <p>
 * anagramm
 * marganaa
 * Sample Output 1
 * <p>
 * Not Anagrams
 * Explanation 1
 * <p>
 * Character	Frequency: anagramm	Frequency: marganaa
 * A or a	3	4
 * G or g	1	1
 * N or n	1	1
 * M or m	2	1
 * R or r	1	1
 * The two strings don't contain the same number of a's and m's, so we print "Not Anagrams".
 * <p>
 * Sample Input 2
 * <p>
 * Hello
 * hello
 * Sample Output 2
 * <p>
 * Anagrams
 * Explanation 2
 * <p>
 * Character	Frequency: Hello	Frequency: hello
 * E or e	1	1
 * H or h	1	1
 * L or l	2	2
 * O or o	1	1
 * The two strings contain all the same letters in the same frequencies, so we print "Anagrams".
 * <p>
 * Java 8
 */
public class Anagrams {
    public static boolean isAnagram(String a, String b) {
        Map<String, Integer> aFreq = new TreeMap<>();
        Map<String, Integer> bFreq = new TreeMap<>();
        Arrays.stream(a.split("")).filter(String::isBlank).map(String::toLowerCase).forEach(str -> aFreq.put(str, aFreq.containsKey(str) ? aFreq.get(str) + 1 : 1));
        Arrays.stream(b.split("")).map(String::toLowerCase).forEach(str -> bFreq.put(str, bFreq.containsKey(str) ? bFreq.get(str) + 1 : 1));
        //With collection
        //return aFreq.equals(bFreq);
        // Without collection
        Pattern.compile("[a-z]");
        return sort(a.toLowerCase()).equals(sort(b.toLowerCase()));
    }

    public static String sort(String str) {
        char temp = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] > chars[i]) {
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(Anagrams.isAnagram("anagram", "margana"));
    }
}
