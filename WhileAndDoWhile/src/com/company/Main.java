package com.company;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        while(count!=6){
            System.out.println("Count value is " + count);
            count++;
        }
        for(int i=1;i!=6;i++){
            System.out.println("Count = " + i);
        }
        count =1;
        do{
            System.out.println("Count value is " + count);
            count++;
        }while (count!=6);

        int startNumber =4;
        int endNumber = 22;
        int evenNumbers =0;
        int sum =0;
//        while(startNumber<=endNumber){
//            if(isEvenNumber(startNumber))
//                System.out.println(startNumber);
//            startNumber++;
//        }

        while(startNumber<=endNumber){
            startNumber++;
            if(!isEvenNumber(startNumber)){        //The following can be done in another way that is by using else
                continue;                  //instead of continue. if(!isEvenNumber(startNumber){}else{sout;}
            }                              //For the above the if body needs to be empty
            System.out.println("The Even numbers are " + startNumber);
            evenNumbers++;
            sum += startNumber;
            if(evenNumbers==5)
                break;
        }
        System.out.println("The total of even numbers = " + sum);
    }
    public static boolean isEvenNumber(int number){
        return number % 2 == 0;
    }
}
