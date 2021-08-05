package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number=0;      //This whole challenge can be done by using only 1 loop. Here the for loop needs
        int sum=0;          //to be modified to while(int i <10) and i++ should be in body of if statement
        boolean hasNextInt;     // The following changes are to be done along with removal of while
	    for(int i=1;i<=10;i++){
	        while(true){             //remove
                System.out.println("Enter the number #" + i +":");
                hasNextInt = scanner.hasNextInt();
                if(hasNextInt){
                    number = scanner.nextInt();
                    sum +=number;
                    break;         //remove
                }else{
                    System.out.println("Enter valid number");
                }scanner.nextLine(); //remove
            }scanner.nextLine();   //This is handling both, the invalid input and the enter key
        }
        System.out.println("The sum of input numbers = " + sum);
	    scanner.close();
    }
}
