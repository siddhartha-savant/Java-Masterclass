package com.company;

public class Main {
    public static void main(String[] args) {
        int add = 0;
        int count = 0;
	    for(int i=1;i<=1000;i++){
	        if(i%3==0 && i%5==0){
                System.out.println("The number divisible by both 3 & 5 is " + i);
                add = add + i;
                count++;
                System.out.println(count);
                if(count>4)
                    break;
            }
        }
        System.out.println("The sum of the numbers is " + add);
    }
}
