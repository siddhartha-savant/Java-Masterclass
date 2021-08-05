package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birth year:");
        boolean hasNextInt = scanner.hasNextInt();

        if(hasNextInt){
            int birthYear = scanner.nextInt();
            scanner.nextLine();  //handle next line character (enter key)

            int age = 2020-birthYear;

            System.out.println("Enter your name:");
            boolean hasNextInt2 = scanner.hasNextInt();


            if(birthYear<1900||hasNextInt2){
                System.out.println("Invalid Input..Please enter correct birth year or correct name next time");
            }else{
                String name = scanner.nextLine();
                System.out.println("Your name is " + name);
                System.out.println("Your birth year is "+ birthYear + " and your age is " + age);
            }

        }else{
            System.out.println("Invalid Input Entered");
        }

        scanner.close();
    }
}
