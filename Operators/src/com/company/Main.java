package com.company;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2; // 1 + 2 = 3
        double result1;
        result++;
        System.out.println(result);

        result += 2;
        System.out.println(result);

        result *=2;
        System.out.println(result);

        result1 = (double) (result % 6);
        System.out.println(result1);

        result1 /=5;
        System.out.println(result1);

        int newvalue = 100;
        if(newvalue == 100){
            System.out.println("This is correct");
        }
        boolean isCar = true;
        if(!isCar != true){
            System.out.println("This is the car");
        }


    }
}
