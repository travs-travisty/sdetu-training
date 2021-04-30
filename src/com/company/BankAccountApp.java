package com.company;

public class BankAccountApp {

    public static void main(String[] args) {
	// write your code here
        BankAccount acc1 = new BankAccount("465329874", 1000);
        BankAccount acc2 = new BankAccount("760382345", 2000);
        BankAccount acc3 = new BankAccount("238594505", 2500);

        acc1.setName("Johnny");
        System.out.println(acc1.getName());
        acc1.makeDeposit(500);
        acc1.makeDeposit(600);
        acc1.payBill(1000);
        acc1.accrue();
        System.out.println(acc1.toString());

    }
}

class BankAccount implements Interest {
    //properties of bank account
    private static int iD = 1000;                 // internal ID
    private String accountNumber;   // ID + random 2-digit number + first two of SSN
    private static final String routingNumber = "005400657";
    private String name;
    private String SSN;
    private double balance;
    private String email;

    // constructor
    public BankAccount(String SSN, double initDeposit) {
        balance = initDeposit;
        this.SSN = SSN;
        iD++;
        setAccountNumber();
    }

    private void setAccountNumber(){
        int random = (int) (Math.random() * 100);
        accountNumber = iD + "" + random + SSN.substring(0, 2);
        System.out.println("Your account number " + accountNumber);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setEmail() {
        int random = (int) (Math.random() * 100);
        email = name + "" + random + "" + "@STUDENT.UMGC.EDU";
        System.out.println("Email: " + email);
    }
    public void payBill(double amount){
        balance = balance-amount;
        System.out.println("Paying bill: " + amount);
        showBalance();
    }
    public void makeDeposit(double amount){
        balance = balance + amount;
        System.out.println("Making deposit: " + amount);
        showBalance();
    }
    public void showBalance(){
        System.out.println("Balance: " + balance);
    }


    @Override
    public void accrue() {
        balance = balance * (1 + rate/100);
        showBalance();
    }

    @Override
    public String toString(){
        return "[Name: " + name + "]\n[Account Number: " + accountNumber + "]\n" + "[Routing Number: " + routingNumber + "]\n[Balance: " + balance + "]\n" + "[Email: " + email;
    }
}
//Access Modifiers, Encapsulation, Constructors, Getters & Setters, Interfaces, Inheritance, Overriding, Abstraction