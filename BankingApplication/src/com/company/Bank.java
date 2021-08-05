package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<Branch>();  //Instead of initialzing over here, could make
                                                                  //a constr. and initialize over there
    public Branch createObjectBranch(String name) {
        Branch createBranch = new Branch(name);
        return createBranch;
    }

    public void addNewBranch(String name) {
        branches.add(createObjectBranch(name));
    }

    public void addCustomer(String name, Double transaction, int number) {
       // listOfBranches();
        branches.get(number - 1).addNewCustomer(name, transaction);
    }

    public void addTransactions(String name, Double amount, int number) {
        int i;
        for (i = 0; i < branches.size(); i++) {
            if (branches.get(i).searchCustomer(name) != -1) {
             //   System.out.println("Customer exists");
            }
            branches.get(i).addTransaction(name, amount, number);
        }
    }
    public void listOfCustomers(int number){
     //   listOfBranches();
        branches.get(number-1).listCustomers();
    }
    public void listOfBranches(){
        System.out.println("List of branches:");
        for (int i = 0; i < branches.size(); i++) {
            System.out.println(i + 1 + ". " + branches.get(i).getBranchName());
        }
    }
}
