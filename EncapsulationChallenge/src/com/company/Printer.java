package com.company;

public class Printer {
    private int tonerLevel;
    private int numberOfPagesPrinted;
    private boolean duplexPrinter;

    public Printer(int tonerLevel, int numberOfPagesPrinted, boolean duplexPrinter) {
        if(tonerLevel>100){
            this.tonerLevel=100;
        }
        this.tonerLevel = tonerLevel;
        this.numberOfPagesPrinted = numberOfPagesPrinted;
        this.duplexPrinter = duplexPrinter;
    }
    public void fillTheTank(int toner){
        this.tonerLevel+=toner;
        if(tonerLevel>0){
            this.tonerLevel =100;
        }
    }
    public void pagesPrinted(int pages){
        for(int i =1;i<=pages;i++){
            System.out.println("Page " + i + " printed");
        }
        numberOfPagesPrinted=pages;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public boolean isDuplexPrinter() {
        return duplexPrinter;
    }
}

