package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Write a class called MyRegex which will contain a string pattern. You need to write a regular expression and assign it to the pattern such that it can be used to validate an IP address. Use the following definition of an IP address:
 * <p>
 * IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
 * Some valid IP address:
 * <p>
 * 000.12.12.034
 * 121.234.12.12
 * 23.45.12.56
 * Some invalid IP address:
 * <p>
 * 000.12.234.23.23
 * 666.666.23.23
 * .213.123.23.32
 * 23.45.22.32.
 * I.Am.not.an.ip
 * In this problem you will be provided strings containing any combination of ASCII characters. You have to write a regular expression to find the valid IPs.
 * <p>
 * Just write the MyRegex class which contains a String . The string should contain the correct regular expression.
 * <p>
 * (MyRegex class MUST NOT be public)
 * <p>
 * Sample Input
 * <p>
 * 000.12.12.034
 * 121.234.12.12
 * 23.45.12.56
 * 00.12.123.123123.123
 * 122.23
 * Hello.IP
 * Sample Output
 * <p>
 * true
 * true
 * true
 * false
 * false
 * false
 */
public class JavaRegex {

    public static void main(String[] args) {
        String pattern = "^((([0|1]?\\d{1,2})|25[0-5]|2[0-4]\\d)\\.){3}([0-1]?\\d{1,2}|25[0-5]|2[0-4]\\d)$";
        List<String> ipAddressList = Arrays.asList(new String[]{"000.12.12.034",
                "121.234.12.12",
                "23.45.12.56",
                "000.12.234.23.23",
                "000.12.234.23.23",
                ".213.123.23.32",
                "23.45.22.32.",
                "I.Am.not.an.ip"});

        ipAddressList.forEach(ip -> System.out.println(Pattern.compile(pattern).matcher(ip).matches()));
    }
}
