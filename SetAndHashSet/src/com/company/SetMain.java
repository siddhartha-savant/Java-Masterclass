package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i<=100;i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("The union of squares and cubes has " + union.size() + " numbers");


        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("The intersection of squares and cubes has " + intersection.size() + " numbers");
        for(Integer number: intersection){
            System.out.println(number + " is a square of " + Math.sqrt(number) + " and cube of " + Math.cbrt(number));
        }

        Set<String> words = new HashSet<>();
        String sentence = "This is the year of the fox";
        String[] arrayOfWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayOfWords));

        for(String s:words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords)); //Only one 'to' is added in the hashset

        //We use the Arrays.asList method because for the time being there is no literal for Set or Map
        //As there is no literal for Set or Map, we use the literal on line 42 and line 45 which is for Array
        //to add the elements in the Set.

        System.out.println("Nature - Divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("Divine - Nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);


        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);


        if(nature.containsAll(divine)){
            System.out.println("Divine is the subset of nature");
        }
        if(nature.containsAll(intersectionTest)){
            System.out.println("IntersectionTest is the subset of nature");
        }
        if(divine.containsAll(intersectionTest)){
            System.out.println("IntersectionTest is the subset of divine");
        }
    }
    private static void printSet(Set<String> temp){
        System.out.print("\t");
        for (String s:temp){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
