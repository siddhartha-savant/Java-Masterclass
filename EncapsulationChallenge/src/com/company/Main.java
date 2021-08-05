package com.company;

public class Main {

    public static void main(String[] args) {
        Printer laserPrinter = new Printer(50,40,true);
        Printer dotMatrix = new Printer(10,100,false);
        Printer inkJet = new Printer(60, 60,true);

        Paper paper = new Paper("Hardbind","Spiral");

        Computer computer = new Computer(paper,laserPrinter);

        System.out.println("The required computers are: "+ computer.computersNeeded());
        System.out.println(laserPrinter.getNumberOfPagesPrinted());
        System.out.println(computer.getPrinter().getNumberOfPagesPrinted());

        //Both sout above are going to print the same value. Therefore, it is preferred not to write getters
        //for classes that have objects of one class as their field variables i.e. composition class.
        //as well as for inherited class.
    }
}
