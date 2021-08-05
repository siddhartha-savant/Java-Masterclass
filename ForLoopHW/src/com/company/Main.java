package com.company;

public class Main {

    public static void main(String[] args) {
        int numberOfPrime=0;
        for(int i=2; i<=20; i++){
            if(isPrime(i)){
                System.out.println(i + " is a prime number");
                numberOfPrime++;
                if(numberOfPrime == 3){
                    break;
                }
            }

        }
        System.out.println(isPrime(50));
    }


    public static boolean isPrime(int n){
        if(n==1){
            return false;
        }else {
            for(int i = 2; i<=n/2; i++){ //Instead of i<=n/2, i<=(long)Math.sqrt(n); could have been used.
                if(n%i==0) {
                    System.out.println("hello");
                    return false;

                }
            }
        }return true;
    }
}

