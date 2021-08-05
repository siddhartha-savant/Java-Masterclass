package com.company;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() { //This is an anonymous inner class implementing
        @Override    //a comparator and its providing an implementation of the single compare method. The compare method
        public int compare(Seat seat1, Seat seat2) {//is similar to the compareTo method. Both return the same result
            if(seat1.getPrice()<seat2.getPrice()){
                return -1;
            }else if(seat1.getPrice()>seat2.getPrice()){
                return 1;
            }else{
                return 0;
            }
        }
    };

    public Theatre(String theatreName, int numRows, int numOfSeatsInRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= numOfSeatsInRow; seatNum++) {
                double price = 12.00;

                if((row<'D') && (seatNum>=4 && seatNum<=9)){
                    price = 14.00;
                }else if((row>'F') || (seatNum<4 || seatNum > 9)){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum),price); //The format method makes sure
                seats.add(seat); //they are allocated with a leading 0. eg. A01....A09,A10....B01.. and so on
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber,0);
        int foundSeat = Collections.binarySearch(seats,requestSeat,null);
        if(foundSeat>=0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

    }

    public Collection<Seat> getSeats() {
        return seats;
    }


    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
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

        public double getPrice() {
            return price;
        }
    }
}