package com.company._static;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("First Instance");
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstance());

        StaticTest secondInstance = new StaticTest("Second Instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstance());

        StaticTest thirdInstance = new StaticTest("Third Instance");
        System.out.println(thirdInstance.getName() + " is instance number  " + StaticTest.getNumInstance());

        //Here the thirdInstance.getNumInstance() could also be instead written as secondInstance.getNumInstance()
        //or it can also be called from the class name (which is the correct way) as shown in code above: StaticTest.getNumInstance()
        //This won't do any difference, as all the three instances are pointing to the same static variable.

        //java.com.company._static.Main is the statement used to run the program from the command line.
        int answer = multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("Multiplier is " + multiplier);
    }

    public static int multiply(int number){
        return number*multiplier;
    }
}
