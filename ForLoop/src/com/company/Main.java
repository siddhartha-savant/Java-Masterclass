package com.company;

public class Main {

    public static void main(String[] args) {
        for(int i=2; i<9; i++){
            System.out.println("10,000 at " + i + "% interest = " + calculateInterest(10000,i));
        }  //One might point out that the datatype of i is actually a int and the method parameter has datatype
        //double. Here, java is automatically converting the whole number to a double for us.
        //We can typecast it to double if we want like:  ...calculateInterest(10000,(double) i));

        for(int i=8; i>1; i--) {
            System.out.println("10,000 at " + i + "% interest = " + calculateInterest(10000, i));
        }
        int numberOfPrime=0;
        for(int i=2; i<=20; i++){
            if(isPrime(i)==true){    //can be simplified to if(isPrime(i))
                System.out.println(i + " is a prime number");
                numberOfPrime++;    //This variable is initialized and defined outside the loop. Reason if in loop
                if(numberOfPrime == 3){  //it will always be initialized to 0. and the corresponding if statement
                    break;           //would not be satisfied
                }
            }

        }
    }
    public static double calculateInterest(double amount, double interestRate){
        return amount * interestRate / 100;
    }
    public static boolean isPrime(int n){
        if(n==1){
            return false;
        }else {
            for(int i = 2; i<=n/2; i++){ //Instead of i<=n/2, i<=(long)Math.sqrt(n); could have been used.
                if(n%i==0) {   //Tbh prime no. is checked just by dividing the no. by 2,3,5,7 and the sqrt of the no.
                    return false; //e.g. 17 is prime, 34 = 17 * 2, 13 is prime, 39 = 13 * 3, etc
                }                //The sqrt helps as follows, 11 is prime, 121 = 11 * 11.
            }                   //So the use of i<=(long)Math.sqrt(n) is quicker as less computation is carried out.
        }return true;
    }
}                            //The less computation is carried out only in terms of prime numbers. This is because
                             //for non prime numbers, the value is returned false in the first if statement. i.e
                             //the for loop is terminated. However, in case of prime numbers less iterations are
                             //followed for the value to be returned true.

//For ex. 17, 1st case (n/2): 2,3,4,5,6,7,8 are the i values used to get out of loop and return true.
        // 2nd case sqrt(n) : 2,3,4 are the i values used to get out of loop and return true.