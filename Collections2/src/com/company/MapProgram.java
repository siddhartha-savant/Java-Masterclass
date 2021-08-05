package com.company;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "a compiled high level, platform independent, object-oriented programming language");
        languages.put("Python", "an interpreted, object oriented, high level programming language with high level semantics");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All purpose Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));


        System.out.println(languages.get("Java"));
        languages.put("Java", "This course is about Java");  //The value for key "Java" is overwritten
        System.out.println(languages.get("Java"));


        System.out.println(languages.put("Lisp", "No madness now"));  //This line still gets processed, however the
        System.out.println(languages.get("Lisp"));//previous value stored in the Map is returned.  The next line
        //where get is used, there you get the desired output. This helps us to understand whether the value
        // is added for the first time or not. This is because for the first time null is returned. OR we can do
        //this pragmatically by using the .containsKey to check whether that key exists in the map or not.

        if(languages.containsKey("Java")){
            System.out.println("Already added in map");
        }else{
            languages.put("Java","This course is about Java");
        }


        System.out.println("===================================");



       // languages.remove("Lisp");   //The remove method returns true or false (boolean). Therefore, we are able
        if(languages.remove("Algol","a family of algorithmic languages")){ //to write it in an if statement
            System.out.println("Algol removed");
        }else{
            System.out.println("Value to key does not match");
        }


        System.out.println(languages.replace("Lisp","No madness now","The madness has returned"));
        System.out.println(languages.replace("Scala","will not be added"));//will return null as it is not present in map
        //We can also add the .replace method in a if statement just as we did above for .remove as it also returns
        //boolean

        for(String key: languages.keySet()){
            System.out.println(key + ": " + languages.get(key));
        }

    }
}
