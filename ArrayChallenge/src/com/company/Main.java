package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int [] intArray = getIntegers(5);
        //printArray(intArray);

        printArray(sortArray(intArray));

    }
    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integers:\r");
        int[] array = new int[number];
        for(int i = 0; i<array.length;i++){
            array[i]= scanner.nextInt();
        }
        return array;
    }
    public static void printArray(int[] array1){
        for(int i = 0; i<array1.length;i++){
            System.out.println("The element " + i + " has value " + array1[i]);
        }
    }
    public static int[] sortArray(int[] array){
        int temp=0;
        int temp1=0;
        int[] arraySorted = new int[array.length];
        for(int i = 0; i<array.length;i++){
            temp=array[i];
            for(int j = 0;j<array.length;j++){
                if(temp<array[j]){                    //In this sorting, we first find out the highest int out of
                    temp=array[j];                   //the array, then we make that int 0, again find the
                    temp1=j;                         // highest int, make that int 0, repeat. However, there can
                }                                    //be negative integers as well. Therefore, MIN_VALUE is used.
                if(j==array.length-1 && temp==array[i]){
                    temp1=i;
                }
            }
            array[temp1]=Integer.MIN_VALUE;
            arraySorted[i]=temp;
        }
        return arraySorted;
    }
}

