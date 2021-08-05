package com.company;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers = new ArrayList<Customer>(); // Instead of initializing it over here
    private String branchName;                                         //could have done it in constructor

    public Branch(String branchName) {
        this.branchName = branchName;
        //this.customers = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {  //We could have created a variable for ArrayList<Customer> in
        return customers;                       //Bank class and used getter to copy this list in that variable
    }                                           //We could then use for loop to print the list of customers

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Customer createObjectCustomer(String name, Double transaction){
        Customer createCustomer = new Customer(name);
        createCustomer.setTransactions(transaction);
        return createCustomer;
    }
    public void addNewCustomer(String name, Double transaction){
        customers.add(createObjectCustomer(name, transaction));
    }
    public int searchCustomer(String name){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public void addTransaction(String name, Double amount, int number){
        Double transaction;
        if(searchCustomer(name)>=0){
            System.out.println("Hello " + name + " !");
     //       System.out.println("Do you want to deposit or withdraw?\n Press 1. Deposit\t 2. Withdraw");
            if(number==1){
                transaction = customers.get(searchCustomer(name)).lastTransaction() + amount;
                System.out.println("You have made a deposit of: " + amount);
                customers.get(searchCustomer(name)).setTransactions(transaction);
            }else if(number==2){
                if(amount>customers.get(searchCustomer(name)).lastTransaction()){
                    System.out.println("Insufficient funds");
                }else{
                    transaction = customers.get(searchCustomer(name)).lastTransaction() - amount;
                    System.out.println("You have made a withdrawal of: " + amount);
                    customers.get(searchCustomer(name)).setTransactions(transaction);
                }
            }
        }else{
            System.out.println("Sorry! " + name + " does not exist");
        }
    }
    public void listCustomers(){    //We could have implemented this in Bank class by using the getter for
        for(int i=0;i<customers.size();i++){  //ArrayList<Customer> (We have getter, but we are not using it)
            System.out.println(i+1 + ". " + customers.get(i).getName() + customers.get(i).getTransactions());
        }
    }
}

