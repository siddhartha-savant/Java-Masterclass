package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {
	    boolean flag = true;
        printInstruction();
	    while (flag){
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    printInstruction();
                    break;
                case 2:
                    printContacts();
                    break;
                case 3:
                    storeContacts();
                    break;
                case 4:
                    modifyContact();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    searchContact();
                    break;
                case 7:
                    flag=false;
                    break;

            }

        }
    }
    public static void printInstruction(){
        System.out.println("Mi REDMI Mobile Phone");
        System.out.println("Press 1 to show message again");
        System.out.println("Press 2 to print the contacts");
        System.out.println("Press 3 to store new contact");
        System.out.println("Press 4 to modify new contact");
        System.out.println("Press 5 to remove new contact");
        System.out.println("Press 6 to search for contact");
        System.out.println("Press 7 to exit");
    }
    public static void printContacts(){
        mobilePhone.printContact();
    }
    public static void storeContacts(){
        System.out.println("Enter the name of the contact:");
        String name = scanner.nextLine();
        System.out.println("Enter the phone number:");
        String phoneNumber = scanner.nextLine();
        mobilePhone.storeContact(name,phoneNumber);
    }
    public static void modifyContact(){
        System.out.println("Enter the name of the contact you want to modify:");
        String name = scanner.nextLine();
        System.out.println("Enter the new name:");
        String newName = scanner.nextLine();
        System.out.println("Enter the new number:");
        String newNumber = scanner.nextLine();
        mobilePhone.modifyContact(name,newName,newNumber);
    }
    public static void removeContact(){
        System.out.println("Enter the contact name you want to remove:");
        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }
    public static void searchContact(){
        System.out.println("Enter the name of the contact you want to search");
        String name = scanner.nextLine();
        mobilePhone.contactFinder(name);
    }
}
