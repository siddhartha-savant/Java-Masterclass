package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();

//        placesToVisit.add("Pune");
//        placesToVisit.add("Konkan");
//        placesToVisit.add("Sindhdurg");
//        placesToVisit.add("Nashik");
//        placesToVisit.add("Lonavala");
//        placesToVisit.add("Mahableshwar");

        addInOrder(placesToVisit,"Pune");
        addInOrder(placesToVisit,"Mumbai");
        addInOrder(placesToVisit,"Konkan");
        addInOrder(placesToVisit,"Nashik");
        addInOrder(placesToVisit,"Lonavala");
        addInOrder(placesToVisit,"Mahabaleshwar");

        printPlacesToVisit(placesToVisit);

        addInOrder(placesToVisit,"Aurangabad");

        printPlacesToVisit(placesToVisit);

        visitCities(placesToVisit);
    }
    private static void printPlacesToVisit(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()){                                   //i.hasNext() checks if there is another entry
            System.out.println("Now visiting.." + i.next());   //the i.next() is equivalent to i++ in for loop
        }                                          //It returns the current value and then it moves to the next entry
        System.out.println("==============");
    }
    private static boolean addInOrder(LinkedList<String> linkedList, String newPlace){
        ListIterator<String> i = linkedList.listIterator(); //This line where you are creating the listIterator is
        while (i.hasNext()){                                //still not pointing to the first entry
            int comparison = i.next().compareTo(newPlace);  //i.next() points to the first record
            if(comparison==0){                       //Also note writing methods like .next() are to be avoided
                System.out.println(newPlace + " already added as destination");
                return false;
            }else if(comparison>0){
                i.previous();                   //we go back to the previous entry as i.next() returns the current
                i.add(newPlace);               //entry and points to the next entry. But we want to add String in
                return true;                  //the place of the compared entry.
            }
        }
        i.add(newPlace);
        return true;
    }
    private static void visitCities(LinkedList cities){   //here we directly passed LinkedList without specifying the
        Scanner scanner = new Scanner(System.in);        //type of elements in the LinkedList.
        ListIterator<String>  listIterator = cities.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        if(cities.isEmpty()){
            System.out.println("No cities in the itinerary");
            return;
        }else{
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holidays are over");
                    quit=true;
                    break;

                case 1:
                    if(!goingForward){                 //This if statement handles the iteration problem in LinkedList
                        if(listIterator.hasNext()){
                            listIterator.next();      //This will take the cursor to the next entry
                        }
                        goingForward=true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());   //This will take the cursor to the
                    }else{                                                       //next entry one more time
                        System.out.println("This is the last destination");
                    }
                    break;

                case 2:
                    if(goingForward){                //This if statement handles the iteration problem in LinkedList
                        if(listIterator.hasPrevious()){
                            listIterator.previous();   //This will take the cursor to the previous entry
                        }
                        goingForward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous()); //This will take the cursor to
                    }else{
                        //the previous entry one more time
                        System.out.println("This is the first destination");
                    }
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available actions\n press ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print actions");
    }
}
