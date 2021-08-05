package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        try{
            int result = divide();
            System.out.println(result);
        }catch(ArithmeticException  | NoSuchElementException e){  //Bitwise inclusive OR for catching multiple exceptions
            System.out.println(e.toString());
            System.out.println("Unable to divide, autopilot closing");
        }
    }
    private static int divide(){
        int x;
        int y;
//        try{               //However we won't catch exceptions in the divide method. They would be caught in the
            x = getInt();       //main method instead.
            y = getInt();
            System.out.println("x is " + x + " y is " + y);
            return x/y;
//        }catch (NoSuchElementException e){
//            throw new ArithmeticException("no such element");
//        }catch (ArithmeticException e){
//            throw new ArithmeticException("divide by zero");
//        }
    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while(true){
            try{
                return s.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter an integer");
                s.nextLine();
            }
        }
    }
}
