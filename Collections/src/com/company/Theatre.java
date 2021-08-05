package com.company;

import java.util.*;

public class Theatre {
    private final String theatreName;
    public List<Seat> seats = new ArrayList<>(); //This was private earlier, made it public so as to check
                                                //collection methods like sort which is
    public Theatre(String theatreName, int numRows, int numOfSeatsInRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);  //lastRow will have the int value of the lastRow alphabet.
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= numOfSeatsInRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum)); //The format method makes sure
                seats.add(seat); //they are allocated with a leading 0. eg. A01....A09,A10....B01.. and so on
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats,requestSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        for (Seat i : seats) {
//            System.out.print(".");   //As you can see in the output, this is a brute force type of search
//            if (i.getSeatNumber().equals(seatNumber)) {//We can instead use binary search of collection class
//                requestSeat = i;      //In order to get that to work we need to implement the comparable interface
//                break;                //in our Seat class, so that java knows how to compare two seats.
//            }
//        }
//        if (requestSeat == null) {
//            System.out.println("There does not exist this seat");
//            return false;
//        } else {
//            return requestSeat.reserve();
//        }
    }

    public void getSeats() {
        for (Seat i : seats) {
            System.out.println(i.getSeatNumber());
        }
    }


    public class Seat implements Comparable<Seat>{  //This class was private earlier made it public
        private final String seatNumber;  //No matter whether the seat is occupied or not, this variable is final
        private boolean reserved = false; //because the seatNumber is permanent. Also all the seats at first won't
                                          //be occupied. So initially, reserved = false;
        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.getSeatNumber().compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved=true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }else{
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved=false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            }else{
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public String toString() {
            return "Seat{" +
                    "seatNumber='" + seatNumber + '\'' +
                    ", reserved=" + reserved +
                    '}';
        }
    }
}