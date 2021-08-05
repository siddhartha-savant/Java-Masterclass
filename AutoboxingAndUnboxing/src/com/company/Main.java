package com.company;

import java.util.ArrayList;

class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}
public class Main {


    public static void main(String[] args) {

        String[] stringArray = new String[10];
        int[] integerArray = new int[10];

        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("Sid");
   //     ArrayList<int> intArrayList = new ArrayList<int>();      //Not possible

        ArrayList<IntClass> intArrayList = new ArrayList<IntClass>();
        intArrayList.add(new IntClass(21));               //adding new objects every time

        Integer integer = new Integer(22);
        Double doubleValue = new Double(12.22);

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for(int i =0;i<=10;i++){
            integerArrayList.add(Integer.valueOf(i));  //The highlighted part is Autoboxing where we are taking the
        }                                      //primitive type and we are going to the object wrapper ie the Class
                                         //The need for writing ...add( new Integer.valueOf(i)); is not required
                                        //this is because the class is java inbuilt. whereas if we look at line 33
                                       //the class was user defined. Therefore, we had to write 'new' keyword to
                                      //create new object every time and save them in the list. Here java does it
                                     //internally

        for(int i =0;i<=10;i++){
            System.out.println(i + " --> " + integerArrayList.get(i).intValue()); //This is Unboxing
            //the intValue converts it from Integer data type back to primitive int data type.

        }

        //A much easier way to writing instances for Integer, Double wrapper class is directly writing their values
        //Java on compile time converts it accordingly.

        Integer myValue = 20;   //Integer.valueOf(20);  <--- this is done compile time
        int temp = myValue;    //myValue.intValue();  <--- this is done compile time

        //Therefore we can simplify the earlier loops as follows

        for(int i =0;i<=10;i++){
            integerArrayList.add(i);
        }
        for(int i =0;i<=10;i++){
            System.out.println(i + " --> " + integerArrayList.get(i));


        }
    }
}
