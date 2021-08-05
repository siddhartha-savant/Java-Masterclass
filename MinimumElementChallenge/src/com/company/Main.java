package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of integers for array:\r"); //The \r is handling enter key problem
        int count = scanner.nextInt();                                  //just like scanner.println does

        int[] array = readIntegers(count);
        System.out.println("The array formed is: "+ Arrays.toString(array));
        System.out.println("The min value in the array is: " + findMin(array));
    }
    public static int[] readIntegers(int count){
        int[] array = new int[count];
        System.out.println("Now enter the " + count + " numbers:\r");//The \r is handling the enter key problem
        for(int i=0;i<count;i++){
            array[i]= scanner.nextInt();
        }
        return array;
    }

    public static int findMin(int[] array){
        int min=array[0];
        for(int i=0;i<array.length-1;i++){
            if(min>array[i+1]){
                min=array[i+1];
            }
        }
        return min;
    }
}
