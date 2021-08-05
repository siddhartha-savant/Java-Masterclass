package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>();

        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);

        printDoubled(items);
    }
    private static void printDoubled(ArrayList<Integer> items){
        for (int i: items){
            System.out.println( i * 2 );   //We have to tell Java what kind of Object is there in ArrayList
        }                                           //That's why casting to Integer wrapper class is done.
    }                                               //Once we specify the type parameter casting is not required
}                                                   //Also Object i:items is not required. Change Object-->int
