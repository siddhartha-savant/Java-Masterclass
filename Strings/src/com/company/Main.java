package com.company;

public class Main {

    public static void main(String[] args) {

        String myString = "Hello, This is a String";
        System.out.println("Your String is " + myString);
        myString = myString + " and this is more";
        System.out.println("Your String is " + myString);
        myString = myString + " \u00A9 Copyrighted line";
        System.out.println("Your String is " + myString);

        String lastString = "100";
        int intLast = 100;
        lastString = lastString + intLast;
        System.out.println(lastString);

    }
}
