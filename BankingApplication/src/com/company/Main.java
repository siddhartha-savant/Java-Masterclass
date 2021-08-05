package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean quit = false;
        bankGreetings();
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: (5 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    addBranch();
                    break;

                case 2:
                    addCustomer();
                    break;

                case 3:
                    addTransaction();
                    break;

                case 4:
                    listOfCustomer();
                    break;

                case 5:
                    printActions();
                    break;
            }
        }
    }
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to add branch\n" +
                "2  - to add customer\n" +
                "3  - to add transaction\n" +
                "4  - to list the customers\n" +
                "5  - to print a list of available actions.");
        System.out.println("Choose your action");
    }
    private static void addBranch(){
        System.out.println("Admin access only... Enter the name of branch:");
        String branchName = scanner.nextLine();
        bank.addNewBranch(branchName);
        System.out.println("Admin access only...Branch added");
    }
    private static void addCustomer(){
        System.out.println("Enter the name of customer:");
        String name = scanner.nextLine();
        System.out.println("Enter the initial amount for account opening:");
        Double amount = scanner.nextDouble();
        scanner.nextLine();
        bank.listOfBranches();
        System.out.println("Enter the branch where you want to be added:");
        int number = scanner.nextInt();
        scanner.nextLine();
        bank.addCustomer(name,amount,number);
        System.out.println("Customer added successfully");
    }
    private static void addTransaction(){
        System.out.println("Enter the name of customer:");
        String name = scanner.nextLine();
        System.out.println("Enter the transaction amount:");
        Double amount = scanner.nextDouble();
        //scanner.nextLine();        //No need for a nextLine() after wrapper class Double. This was causing a bug
        System.out.println("Do you want to deposit or withdraw?\n Press 1. Deposit\t 2. Withdraw");
        int number = scanner.nextInt();
        scanner.nextLine();
        bank.addTransactions(name,amount,number);
    }
    private static void listOfCustomer(){
        bank.listOfBranches();
        System.out.println("Enter the branch number whose customers you want to see");
        int number = scanner.nextInt();
        scanner.nextLine();
        bank.listOfCustomers(number);
    }
    private static void bankGreetings(){
        System.out.println("Welcome to Subhadra bank:");
    }

}
