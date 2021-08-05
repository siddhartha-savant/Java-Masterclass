package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int[] myIntArray = new int[5];
	    int[] mySecondArray = myIntArray;    //Both arrays are pointing at the same memory location.

        System.out.println("myIntArray " + Arrays.toString(myIntArray) +
                " mySecondArray " + Arrays.toString(mySecondArray));

        mySecondArray[0] = 10;            //Both will point to the same changed array
        System.out.println("myIntArray " + Arrays.toString(myIntArray) +
                " mySecondArray " + Arrays.toString(mySecondArray));

       modifyArray(myIntArray);

        System.out.println("myIntArray " + Arrays.toString(myIntArray) +
                " mySecondArray " + Arrays.toString(mySecondArray));

    }
    public static void modifyArray(int[] array){
        array[1] = 100;            //The reference is changed as a result the array is changed.
        array = new int[] {1, 2, 3, 4, 5, 6};      //This is not printed because we are dereferencing by using new
    }                                              //The parameter array now points to a different array

}
