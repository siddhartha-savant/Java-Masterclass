package com.company;

public class Main {

    public static void main(String[] args) {

        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("The Min float value " + myMinFloatValue);
        System.out.println("The Max float value " + myMaxFloatValue);
        System.out.println("Both " + myMinFloatValue + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("The Min double value " + myMinDoubleValue);
        System.out.println("The Max double value " + myMaxDoubleValue);

        int myIntValue = 100 / 3;
        float myFloatValue = 5f / 3f;
        double myDoubleValue = 5d / 3f;
        double myDoubleValue2 = 5.26d;
        System.out.println("My Int value " + myIntValue);
        System.out.println("My Float value " + myFloatValue);
        System.out.println("My Double value " + myDoubleValue);

        double pounds = 123.45;
        double kilograms = pounds * 0.45359237;
        System.out.println("Kilograms = " + kilograms);
    }
}
