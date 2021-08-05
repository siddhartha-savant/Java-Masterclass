package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {                     //Can't have arrayList as parameter
        this.name = name;
        this.transactions = new ArrayList<Double>();    //Create new object which avoids null pointer exception
    }                                                   //when called. Always better to initialize in the constr.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void setTransactions(Double amount){      //We can't use public static with parameters name and double
        transactions.add(amount);                   //like done in Tim's mobile phone project. This is because,
                                                    //we have two parameters String and arraylist and for arraylist
    }                                              // we can't just have arrayList as a parameter for the method
                                                   //The user can't pass an arrayList as argument. Also transaction
    public double lastTransaction(){               //shouldn't be passed in such a way
        int size = transactions.size()-1;
        return transactions.get(size);
    }
    public void listOfTransaction(){
        for(int i=0;i<transactions.size();i++){
            System.out.print(transactions.get(i) + "  ");
        }
    }

}
