package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("The sum of the digits = " + sumOfDigits(554125));
    }
    private static int sumOfDigits(int number){
        if(number<10){
            return -1;
        }else{
            int sum=0;
            while(number>0){
                sum += number%10;
                number/=10;
        }return sum;
        }
    }
}
