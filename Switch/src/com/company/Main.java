package com.company;

public class Main {

    public static void main(String[] args) {

        int switchNumber = 5;
        switch (switchNumber){
            case 1:
                System.out.println("The number is 1");
                break;

            case 2:
                System.out.println("The number is 2");
                break;

            case 3:case 4: case 5:
                System.out.println("The number is 3, 4 or 5");
                System.out.println("The number is actually " + switchNumber);
                break;

            default:
                System.out.println("The value is neither");
                break;
        }
        char charValue = 'E';
        switch (charValue){
            case 'A':
                System.out.println("The character is A");
                break;

            case 'B':
                System.out.println("The character is B");
                break;

            case 'C': case 'D': case 'E':
                System.out.println("The character is " + charValue);
                break;

            default:
                System.out.println("The character is neither of the above");
                break;

        }
        String month = "JanUaRy";
        switch (month.toLowerCase()){        //toLowerCase is a method of class String
            case "january":
                System.out.println("The month is JAN");
                break;

            default:
                System.out.println("Not given");


        }
    }
}

