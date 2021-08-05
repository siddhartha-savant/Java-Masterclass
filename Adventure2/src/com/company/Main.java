package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locationMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locationMap.put(0, new Location(0, "You are sitting in front of the computer learning Java"));
        locationMap.put(1, new Location(1, "You are sitting at the end of the road before a small building"));
        locationMap.put(2, new Location(2, "You are at the top of a hill"));
        locationMap.put(3, new Location(3, "You are inside a building"));
        locationMap.put(4, new Location(4, "You are in a valley beside a stream"));
        locationMap.put(5, new Location(5, "You are in the forest"));

        locationMap.get(1).addExits("W", 2);
        locationMap.get(1).addExits("E", 3);
        locationMap.get(1).addExits("S", 4);
        locationMap.get(1).addExits("N", 5);
        // locationMap.get(1).addExits("Q",0);   As this is getting repeated every single time, we can instead define
        //it in the constructor of the location class

        locationMap.get(2).addExits("N", 5);
        // locationMap.get(2).addExits("Q",0);

        locationMap.get(3).addExits("W", 1);
        // locationMap.get(3).addExits("Q",0);

        locationMap.get(4).addExits("N", 1);
        locationMap.get(4).addExits("W", 2);
        // locationMap.get(4).addExits("Q",0);

        locationMap.get(5).addExits("S", 1);
        locationMap.get(5).addExits("W", 2);
        // locationMap.get(5).addExits("Q",0);


        int loc = 1;
        while (true) {
            System.out.println(locationMap.get(loc).getDescription());
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
