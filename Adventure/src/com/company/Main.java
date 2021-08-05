package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locationMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExits = new HashMap<>();
        locationMap.put(0, new Location(0, "You are sitting in front of the computer learning Java",null));
        //The map argument is passed null which is actually the right way. However, for that an if statement is added in the
        //constructor to avoid null pointer exception

        tempExits = new HashMap<>();
        tempExits.put("W",2);
        tempExits.put("E", 3);
        tempExits.put("S", 4);
        tempExits.put("N", 5);
        locationMap.put(1, new Location(1, "You are sitting at the end of the road before a small building",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locationMap.put(2, new Location(2, "You are at the top of a hill",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locationMap.put(3, new Location(3, "You are inside a building",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("N", 1);
        tempExits.put("W", 2);
        locationMap.put(4, new Location(4, "You are in a valley beside a stream",tempExits));

        tempExits = new HashMap<>();
        tempExits.put("S", 1);
        tempExits.put("W", 2);
        locationMap.put(5, new Location(5, "You are in the forest",tempExits));

        int loc = 1;
        while (true) {
            System.out.println(locationMap.get(loc).getDescription());
            tempExits.remove("S");
            // Note that we are using the same reference map for every single location. So the above statement
            //will erase the "S" key from all the Maps of all locations. So to make the class truly immutable
            //we need to create new map for each exits instead of reusing the same tempExit. So for that we will
            //change the initialization of map in the constructor of Location class.
            //We will do a similar change as we did one for the getExits method in Location class.
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locationMap.get(loc).getExits();  //the getExits method is therefore used
            System.out.print("Available exits are ");//because even if we make any changes it won't take place on the
            for (String exit : exits.keySet()) {//Map exits which is there in location class
                System.out.print(exit + ", ");
            }
            System.out.println();

            String directionLetter = "A";
            String[] direction = scanner.nextLine().split(" ");
            for (String string : direction) {
                if (string.equalsIgnoreCase("West") || string.equalsIgnoreCase("W")) {
                    directionLetter = "W";
                    break;
                } else if (string.equalsIgnoreCase("East") || string.equalsIgnoreCase("E")) {
                    directionLetter = "E";
                    break;
                } else if (string.equalsIgnoreCase("North") || string.equalsIgnoreCase("N")) {
                    directionLetter = "N";
                    break;
                } else if (string.equalsIgnoreCase("South") || string.equalsIgnoreCase("S")) {
                    directionLetter = "S";
                    break;
                } else if (string.equalsIgnoreCase("Quit") || string.equalsIgnoreCase("Q")) {
                    directionLetter = "Q";
                    break;
                }
                //Instead of this whole if else statements which we are writing so that words are picked out of the
                // sentence that we are writing, we could have instead used another way i.e. created another
                // Map<String, String> vocabulary with key and values as ("QUIT", "Q") ("NORTH", "N") ("SOUTH", "S")
                //("EAST", "E") ("WEST", "W")
                //We'll then write a test condition to check whether the input provided has length > 1 (i.e. sentence
                //is typed) and in that if statement write the .split method. Further we'll check whether
                //vocabulary.containsKey(word) and if it does equate direction to the value of the necessary map key
                //i.e. direction = vocabulary.get(word). There won't be any need to define a separate String directionLetter
            }
                if (exits.containsKey(directionLetter)) {
                    loc = exits.get(directionLetter);
                } else {
                    System.out.println("You cannot go in that direction");
                }
            }
        }
    }
