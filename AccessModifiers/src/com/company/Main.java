package com.company;

public class Main {

    public static void main(String[] args) {
        Account sidsAccount = new Account("Sid");
        sidsAccount.deposit(1000);
        sidsAccount.withdraw(500);
        sidsAccount.deposit(-200);
        sidsAccount.withdraw(-878);
        sidsAccount.calculateBalance();

        System.out.println("Balance is " + sidsAccount.getBalance());
    }
}
