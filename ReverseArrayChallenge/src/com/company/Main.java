package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 3, 4, 5, 8, 7};
        System.out.println("The original array:" + Arrays.toString(array));
        reverse(array);

    }
    public static void reverse(int[] array){
        int temp=0;
        int length = array.length;
        length/=2;
//        if(length%2!=0)        //These two lines are redundant in our code. This is because for odd values length
//            length+=1;        //there is no need to swap the middle number with the middle number. Its redundant
        for(int i=0;i<length;i++){
                temp=array[i];
                array[i]=array[array.length-1-i];
                array[array.length-1-i] = temp;
        }
        System.out.println("The reversed array:" + Arrays.toString(array));
    }
}
