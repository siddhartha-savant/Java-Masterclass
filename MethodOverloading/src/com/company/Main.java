package com.company;

public class Main {

    public static void main(String[] args) {

        double centimeter = calcFeetAndInchesToCentimeters(157);
        System.out.println(centimeter);
    }
    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if(feet>=0 && inches>=0 && inches<=12){
            double totalCentimeters = (12*2.54*feet)+(2.54*inches);
            System.out.println("The total centimeters = " + totalCentimeters);
           return totalCentimeters;
        }else{
            System.out.println("Invalid feet or inches parameter");
           return -1;
        }

    }
    public static double calcFeetAndInchesToCentimeters(double inches){
        if(inches>=0){
            double feet = (int) (inches/12);
            double remainingInches = inches%12;
            System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + " inches");
            return calcFeetAndInchesToCentimeters(feet,remainingInches);
        }else
            return -1;
    }
}
//While calling one method into another is that the protocol of keeping the same data type for parameters - argument
// and return types is not followed. Eg. while calling the calcFeetAndInchesToCentimeters(double feet, double inches)
// method in return statement of calcFeetAndInchesToCentimeters(double inches), the return type of former method can
// be different to the return type of latter method.
//i.e. return type of calcFeetAndInchesToCentimeters(double feet, double inches) can be double,int,char,etc where
//the return type of calcFeetAndInchesToCentimeters(double inches) can be different to  int, char, double,etc.

//Same applies to the parameter and argument .
//calcFeetAndInchesToCentimeters(double feet, double inches) has double parameters whereas the argument while calling
// the function might have different data type like char feet, char inches, etc.

//This is found for methods with different names as well.
