package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean flag = false;
        printInstruction();
        while (!flag) {
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstruction();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();   //We can't directly call the addItem() method in class GroceryList because it has
                    break;       //parameter String item. We need this string from user using scanner.
                case 3:          //Therefore, a separate method is created calling that method from GroceryList
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    flag = true;
                    break;
            }

        }
    }
    public static void printInstruction(){
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search for an item in the list");
        System.out.println("\t 6 - To quit the application");
    }
    public static void addItem(){
        System.out.print("Please enter the grocery item:");
        groceryList.addGroceryItem(scanner.nextLine());
    }
    public static void modifyItem(){
        System.out.print("Enter the current item:");
        String itemNumber = scanner.nextLine();
        System.out.println("Enter the new item:");
        groceryList.modifyGroceryItem(itemNumber,scanner.nextLine());
    }
    public static void removeItem(){
        System.out.print("Enter the item name:");
        String itemNumber = scanner.nextLine();
        groceryList.removeItem(itemNumber);
    }
    public static void searchItem(){
        System.out.println("Enter the item:");
        String searchedItem = scanner.nextLine();
        if(groceryList.onFile(searchedItem)){
            System.out.println("The item " + searchedItem + " is present");
        }else{
            System.out.println("The item " + searchedItem + " is absent");
        }

    }
    public static void processArrayList(){   //Ways in which we can copy arraylists to other arraylists
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());  //this is one way copying the entire contents of one
                                                         //arraylist to another instead of for loop.

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());  //another way

        String[] myArray = new String[groceryList.getGroceryList().size()]; //This is to convert an arraylist
        myArray = groceryList.getGroceryList().toArray(myArray);            //to an array.

    }


}
