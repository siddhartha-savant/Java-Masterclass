package com.example.mylibrary;

public class Series {
    public static long nSum(int n){
        long sum=0;
        for(int i=0;i<=n;i++){
            sum+=i;
        }
        return sum;
    }

    public static long factorial(int n){
        long product=1;
        if(n==0){
            return 1;
        }
        for(int i=1;i<=n;i++){
            product*=i;
        }
        return product;
    }

    public static long fibonacci(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            long nMinus1=1;
            long nMinus2=0;
            long fib=0;
            for(int i=1;i<n;i++){
                fib=nMinus1+nMinus2;
                nMinus2=nMinus1;
                nMinus1=fib;
            }
            return fib;
        }
    }
}
