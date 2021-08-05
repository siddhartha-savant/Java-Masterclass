package com.company;

public class Main {

    public static void main(String[] args) {
	    String numberAsString ="2018";
        System.out.println("The string is " + numberAsString);

        int number = Integer.parseInt(numberAsString);     //Integer is wrapper class.
        System.out.println("The number is " + number);   //The string can be parsed in any primitive data type
                                                  //after using the appropriate wrapper class and variable data type
        numberAsString+=1;
        number+=1;
        System.out.println("The new values are "+ numberAsString + number);
    }
}
