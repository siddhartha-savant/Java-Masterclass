package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locationMap = new Locations();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int loc = 1;
        while (true) {
            System.out.println(locationMap.get(loc).getDescription());

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
