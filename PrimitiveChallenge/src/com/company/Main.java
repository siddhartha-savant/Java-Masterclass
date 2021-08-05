package com.company;

public class Main {

    public static void main(String[] args) {

        byte myFirstByteValue = 100;
        short myFirstShortValue = 1000;

        int myFirstIntValue = 10000;
        long myFirstLongValue = (50000L + 10 * (myFirstByteValue + myFirstShortValue + myFirstIntValue));
        System.out.println("The long value is " + myFirstLongValue);

    }
}
