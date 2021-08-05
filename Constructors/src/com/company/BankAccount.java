package com.company;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(String accountNumber,double balance,String customerName,String email,String phoneNumber){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.customerName=customerName;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public BankAccount(String email, String phoneNumber) {
        this("0987654321",2000,"Sidhu", email, phoneNumber);
    }

    public BankAccount(){
        this("1234567890",1000,"Sid","sid.dis@gmail.com","09517174134");
        System.out.println("This is a full constructor");
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //    public void setAccountNumber(String accountNumber){
//        this.accountNumber=accountNumber;
//    }
//    public void setBalance(double balance){
//        this.balance=balance;
//    }
//    public void setCustomerName(String customerName){
//        this.customerName=customerName;
//    }
//    public void setEmail(String email){
//        this.email=email;
//    }
//    public void setPhoneNumber(String phoneNumber){
//        this.phoneNumber=phoneNumber;
//    }
//    public String getAccountNumber(){
//        return accountNumber;
//    }
//    public double getBalance(){
//        return balance;
//    }
//    public String getCustomerName(){
//        return customerName;
//    }
//    public String getEmail(){
//        return email;
//    }
//    public String getPhoneNumber(){
//        return phoneNumber;
//    }
    public void depositFund(double deposit){
        this.balance=balance+deposit;
        System.out.println("The amount deposited is " + deposit);
        System.out.println("Your total balance is " + balance);
    }
    public void withdrawFund(double withdraw){
        if(balance>=withdraw){
            this.balance=balance-withdraw;
            System.out.println("The amount withdrawn is " + withdraw);
            System.out.println("Your total balance is " + balance);
        }else{
            System.out.println("Insufficient funds for withdrawal brother");
        }
    }
}
