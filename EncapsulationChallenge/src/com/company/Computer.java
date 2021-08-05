package com.company;

public class Computer {
    private Paper paper;
    private Printer printer;
    private Printer printer1;  //For eg: if the total field variables of type Printer are 3, we'll need 3 objects of
    private Printer printer2;  //class Printer declared in the main.
                               //These two fields are also not initialized in constructor. So in main method
                               // there are only two parameters for object of class Computer.

    public Computer(Paper paper, Printer printer) {
        this.paper = paper;
        this.printer = printer;
    }
    public int computersNeeded(){
        printer.pagesPrinted(printer.getNumberOfPagesPrinted());
        if(printer.isDuplexPrinter() && printer.getNumberOfPagesPrinted()<50 && paper.getTypeOfBinding().equals("Spiral")){
            System.out.println("The process is twice fast");
            System.out.println("Therefore, the number of computers required has reduced");
            return 5;
        }else{
            return 10;
        }
    }

    public Printer getPrinter() {   //Read comments in main. The two souts give same output. Therefore not necessary
        return printer;           //to write getters for the composition class.
    }
}
