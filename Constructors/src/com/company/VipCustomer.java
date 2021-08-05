package com.company;

public class VipCustomer {
    private double credit;
    private double limit;
    private String emailAddress;

    public VipCustomer(){
        this(1000,50000,"sid@gmail.com");
        System.out.println("Empty constructor");
    }
    public VipCustomer(double credit, double limit, String emailAddress){
        this.credit=credit;
        this.limit=limit;
        this.emailAddress=emailAddress;
    }
    public VipCustomer(double credit, double limit) {
        this(credit,limit,"siddhartha@gmail.com");
    }

    public double getCredit() {
        return credit;
    }

    public double getLimit() {
        return limit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

}
