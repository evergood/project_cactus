package com.foxminded.homework;

public class MyClassTest {
    public static void main(String[] args) {
        AnagramaMaker action = new AnagramaMaker();
        String result = action.makeAnagram("AAAaaA");
        System.out.println(result);
    }
}
