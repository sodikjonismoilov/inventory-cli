//package app;
//
//import java.util.Scanner;
//
//public class Wallet {
//
//    private double balance;
//
//    public Wallet(double balance) {
//        if (balance < 0){
//            throw new IllegalArgumentException("Balance cannot be negative.");
//        }
//        this.balance = balance;
//    }
//
//    public void deposit(double amount){
//        if (amount <= 0){
//            throw new IllegalArgumentException("Amount cannot be negative.");
//        }
//        this.balance += amount;
//    }
//    public void withdraw(double amount) {
//        if (amount < 0){
//            throw new IllegalArgumentException("Amount cannot be negative.");
//        }
//        if (amount > this.balance){
//            throw new IllegalArgumentException("Amount cannot be greater than balance.");
//        }
//        this.balance -= amount;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public static void main(String[] args){
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter initial balance: ");
//        double balance = scanner.nextDouble();
//        Wallet wallet = new Wallet(balance);
//
//        System.out.println("Enter deposit amount: ");
//        double deposit1 = scanner.nextDouble();
//        System.out.println("Enter withdraw amount: ");
//        double withdraw1 = scanner.nextDouble();
//
//        wallet.deposit(deposit1);
//        wallet.withdraw(withdraw1);
//        System.out.println("Balance: " + wallet.getBalance());
//    }
//
//}
