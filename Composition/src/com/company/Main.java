package com.company;

public class Main {

    public static void main(String[] args) {
        Case aCase = new Case("ideapad330","Lenovo","230",
                new Dimensions(10,10,2));

        Motherboard motherboard = new Motherboard("234","AMD",2,2,"godknows");

        Monitor monitor = new Monitor("ideapad320","Lenoko",10,new Resolution(5,5));

        PC pc = new PC(aCase,monitor,motherboard);
        pc.getMonitor().drawPixelAt(45,54,"Blue");
        System.out.println(pc.getTheCase());
    }
}
