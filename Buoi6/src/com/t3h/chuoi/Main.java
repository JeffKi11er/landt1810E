package com.t3h.chuoi;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "Hello world, hello viet nam";
        int length = str.length();
        System.out.println(length);
        char c = str.charAt(0);
        System.out.println(c);
//        int index = str.indexOf("l");
//        System.out.println(index);
//        int lastIndexOf = str.lastIndexOf("l");
//        System.out.println(lastIndexOf);
//        int secondIndex = str.indexOf("l", index + 1);
//        System.out.println(secondIndex);
        int index = str.indexOf("l");
        while (index != -1) {
            System.out.print(index + "\t");
            index = str.indexOf("l", index + 1);
        }
        System.out.println();
        String str1 = str.substring(2);
        System.out.println(str1);
        str1 = str.substring(2, 5);
        System.out.println(str1);
        str1 = str1.toUpperCase();
        System.out.println(str1);
        str1 = str1.toLowerCase();
        System.out.println(str1);
        str1 = str1.replace("l", "L");
        System.out.println(str1);
        Main main = new Main();
        main.upperCase(str);

        String str2 = str;
        str2 = str2.toUpperCase();
        boolean equals = str.equals(str2);
        System.out.println(equals);
        equals = str.equalsIgnoreCase(str2);
        System.out.println(equals);

        int ascii = str.codePointAt(0);
        System.out.println(ascii);
        System.out.println((char)ascii);

        String s1 = "abc";
        String s2 = "B";
        int compare = s1.compareTo(s2);
        System.out.println(compare);
        String s3 = "     hellow   android   ";
        System.out.println(s3);
        s3 = s3.trim();
        System.out.println(s3);
        String[] arr = str.split(" ");
        for (String s:arr) {
            System.out.println(s);
        }
        char [] chars = str.toCharArray();
        byte[] b = str.getBytes();

        System.out.println("=========================");
        StringBuilder builder = new StringBuilder("Hello world");
        builder.append(" Hello Viet Nam");
        builder.insert(2, "ABC");
        builder.delete(2,5);
        builder.reverse();
        System.out.println(builder.toString());
    }

    private void upperCase(String str) {
        int index = str.indexOf(" ");
        while (index != -1) {
            String s = str.substring(index, index + 2);
            String s1 = s.toUpperCase();
            str = str.replace(s, s1);
            index = str.indexOf(" ", index + 1);
        }
        System.out.println(str);
    }
}
