package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        int[] myIntArray = new int[10];
//        for(int i=1;i<myIntArray.length;i++){       //rather than writing 10 we can instead write myIntArray.length
//            myIntArray[i]=i+10;
//            System.out.println("Element i is " + i + " and value of i is " + myIntArray[i]);
//        }
//        System.out.println(myIntArray[0]);

        int[] myIntArray = getArrayInt(5);
        for(int i = 0;i<myIntArray.length;i++){
            System.out.println("The element " + i + " has following value: " + myIntArray[i]);
        }
    }
    public static int[] getArrayInt(int number){
        System.out.println("Enter " + number + " integers:\r");
        int[] values = new int[number];
        for(int i = 0; i<values.length;i++){
            values[i]= scanner.nextInt();
        }
        return values;
    }
}
