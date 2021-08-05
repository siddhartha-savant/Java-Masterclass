package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("INOX", 8,12);
	    //theatre.getSeats();

//	    if(theatre.reserveSeat("M12")){
//            System.out.println("Please pay amount Rs. 500");
//        }else{
//            System.out.println("Sorry seat is already booked");
//        }
//
//        if(theatre.reserveSeat("H12")){              //The second time we will get an error as it will be
//            System.out.println("Please pay amount Rs. 500");    //already booked
//        }else{
//            System.out.println("Sorry seat is already booked");
//        }

        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats); //We are creating a shallow copy. What that does
        printList(seatCopy);//is creates an ArrayList from all the elements of the list that are passed to the constructor
                            //Note to self is that the seats are not copied. Hence the term shallow copy. They are
                            //effectively the same shared objects.



        seatCopy.get(1).reserve();  //What we are doing here is that we are reserving seat index 1 = "A02" in seatCopy
        if(theatre.reserveSeat("A02")){//However, we are checking if the same seat "A02" is reserved in theatre.seats list
            System.out.println("Please pay");//The seat is reserved which demonstrates shallow copy is created and not a separate copy
        }else{                              //They have separate references but the same object. i.e. there are two separate arraylists
            System.out.println("Seat already reserved");//but the references are to the same object.
        }



        Collections.shuffle(seatCopy); //The printing of both the lists demonstrates that clearly they are separate
        printList(seatCopy);//array lists but with the same object. The reserveSeat as done previously modifies the
        System.out.println("Now printing theatre.seats");//object so the change is reflected in both the lists unlike
        printList(theatre.seats);//in this case.



        Theatre.Seat minSeat = Collections.min(seatCopy); //These methods will work on the list even if seatCopy is
        Theatre.Seat maxSeat = Collections.max(seatCopy);//not sorted.
        System.out.println("The min seat is " + minSeat.getSeatNumber());
        System.out.println("The max seat is " + maxSeat.getSeatNumber());


        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);


        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size()); //This will invoke an error. We are just
        Collections.copy(newList,theatre.seats);//assigning the number of elements possible in the list. However, it is not
                                                //copying the seat objects in the new list
    }
    public static void printList(List<Theatre.Seat> list){
        for(Theatre.Seat seat:list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("====================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list){
        //The ? is generic declaration. This means allow every class which extends Theatre.Seat. Thus our shallow copy
        //seatCopy is all the the List<Theatre.Seat>. Also note the comparable interface implemented by Seat class allows
        //us to use the compareTo method
        
        for(int i=0;i<list.size()-1;i++){    //This is bubble sort. We did the same sorting in ArrayChallenge project
            for(int j=i+1;j<list.size();j++){//As you can see the second loop doesn't start from 0, it actually starts
                if(list.get(i).compareTo(list.get(j))>0){//after the current position the first loop has reached.
                    Collections.swap(list,i,j);
                }
            }
        }
    }
}
