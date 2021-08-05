package com.company;

public class Main {

    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.setAccountNumber("1234567890");
//        bankAccount.setBalance(1000);
//        bankAccount.setCustomerName("Sid");
//        bankAccount.setEmail("sid.dis@gmail.com");
//        bankAccount.setPhoneNumber("09517174134");
//        BankAccount bankAccount1 = new BankAccount("sid@dis.com","987456123");
//        System.out.println("Your account number is " + bankAccount1.getAccountNumber());
//        System.out.println("Your balance is " + bankAccount1.getBalance());
//        System.out.println("Your name is " + bankAccount1.getCustomerName());
//        System.out.println("Your email id is " + bankAccount1.getEmail());
//        System.out.println("Your phone number is " + bankAccount1.getPhoneNumber());
//
//
//
//        bankAccount.depositFund(500);
//        bankAccount.withdrawFund(1500);
//        bankAccount.withdrawFund(200);

        VipCustomer vipCustomer = new VipCustomer(100,10000);
        System.out.println("The credit value is " + vipCustomer.getCredit());
        System.out.println("The limit is " + vipCustomer.getLimit());
        System.out.println("The email address is " + vipCustomer.getEmailAddress());

    }
}
