package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 100;
        int y = 0;
        System.out.println(divideLBYL(x,y));
        System.out.println(divideEAFP(x,y));
        System.out.println("x = " + getLBYL());
        System.out.println("x = " + getEAFP());
    }

    private static int divideLBYL(int x, int y){
        if(y!=0){
            return x/y;
        }else{
            return 0;
        }
    }

    private static int divideEAFP(int x, int y){
        try {
            return x/y;
        }catch (ArithmeticException e){
            return 0;
        }
    }

    private static int getLBYL(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        boolean isInt = true;
        for(int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                isInt=false;
                break;
            }
        }
        if(isInt){
            return Integer.parseInt(s);
        }else{
            return 0;
        }
    }

    private static int getEAFP(){
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        }catch (InputMismatchException e){
            return 0;
        }
    }
}
