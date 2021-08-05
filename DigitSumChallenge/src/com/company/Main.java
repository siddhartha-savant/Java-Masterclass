package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("The sum of all the digits = " + sumDigits(32123));
    }
    public static int sumDigits(int number){
        if(number<10){
            return -1;
        }else{
            int count =0;
            int number1 =0;
            int mod = 10;
            while(true){
                if(number1!=number){
                    number1=number%mod; //Here in this loop we calculated the number of digits in given number
                    mod *= 10;
                    count++;
                    //System.out.println(count);
                }else{
                    break;
                }
            }
            System.out.println("The mod number is " + mod);
            System.out.println("The total number of digits = " + count);
            int div=1;
            for(int i=1;i<count;i++){   //This loop is redundant. The mod value if divided by 100 will give the same
                div*=10;               //divisible value which is calculated in this loop.
            }
            System.out.println("The divisible number = " + div);
            int temp;
            int temp2=0;
            for (int i=1;i<count;i++){          //Could have also written this as while(true)
                temp=number/div;
                temp2+=temp;
                number=number-(temp*div);
                //System.out.println(number); This method is without using a modulo operator method.
               // System.out.println(div);    A project using modulo operator method is named DigitSumChallengeEasy
                div=div/10;
               // System.out.println("New div " + div);
                if(number<10) {
                    temp2 += number;
                    break;
                }
            }return temp2;
        }
    }
}
