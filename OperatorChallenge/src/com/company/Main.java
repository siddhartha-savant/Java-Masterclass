package com.company;

public class Main {

    public static void main(String[] args) {

        double myDoubleVar = 20.00d;
        double myDoubleVar2 = 80.00d;
        double resultVar = 100 * (myDoubleVar + myDoubleVar2);
        System.out.println(resultVar);

        double remVar = resultVar % 40.00d;
        System.out.println(remVar);

        boolean myBooleanVar = (remVar == 0) ? true : false;
        System.out.println(myBooleanVar);

        if(myBooleanVar != true){
            System.out.println("Got some remainder");
        }

    }
}
