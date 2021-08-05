package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int count =0;
	int number1=0;
	int number2=0;
	int max=0;
	int min=0;
        while (true) {

            System.out.println("Enter the Number:");
            boolean isNextInt = scanner.hasNextInt();
            if(isNextInt){
                int number = scanner.nextInt();

                if(count%2==0){
                    number1=number;
                    count++;
                }else{
                    number2=number;
                    count++;
                }                        //This logic is just to decide the max and min numbers which is written
                if(count==2){            //in the case when there is only 1 number inputted.
                    if(number1>number2){  //We can instead not write this logic at all and make changes where
                        max= number1;    //we define max and min. Right now we have written max=min=0;
                        min = number2;   //Instead we write the highest and lowest int values.
                    }else{               //max=-2147483648 and min=21474483647. (We have interchanged the values)
                        max=number2;    //This way when compared with number, the number will always be selected
                        min=number1;
                    }
                }
                if(number1>number2 && number1>max){
                    max=number1;
                }else if(number2>number1 && number2>max){
                    max=number2;
                }
                if(number1<number2 && number1<=min){
                    min=number1;
                }else if(number2<number1 && number2<min){
                    min=number2;
                }
            }else {
                System.out.println("Maximum number: " + max);
                System.out.println("Minimum number: " + min);
                break;
            }scanner.nextLine();
        }
        scanner.close();
    }
}
