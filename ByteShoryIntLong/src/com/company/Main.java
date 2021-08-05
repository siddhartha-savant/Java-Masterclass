package com.company;

public class Main {

    public static void main(String[] args) {

        int myValue = 10000;
        int myMinValue = Integer.MIN_VALUE;
        int myMaxValue = Integer.MAX_VALUE;
        System.out.println("The minimum value is " + myMinValue);
        System.out.println("The maximum value is " + myMaxValue);
        System.out.println("The Busted minimum value is " + (myMinValue - 1)); //Underflow
        System.out.println("The Busted maximum value is " + (myMaxValue + 1)); //Overflow

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("The minimum value is " + myMinByteValue);
        System.out.println("The maximum value is " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("The minimum value is " + myMinShortValue);
        System.out.println("The maximum value is " + myMaxShortValue);
        
        long myLongValue = 1000L;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("The minimum value is " + myMinLongValue);
        System.out.println("The maximum value is " + myMaxLongValue);

        long bigLongLiteralValue = 2147483648L;
        int myNewInt = (myMinValue / 2);

        byte myNewByte = (byte) (myMinByteValue / 2);

    }
}
