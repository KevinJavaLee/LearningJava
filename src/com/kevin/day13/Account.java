package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-11-22:04
 */


public class Account {
    private int id;
    private static int init=1000;//初试值
    private static double  InterestRate ;
    private String password;
    private double balance;
    private static double MiniMoney;

    public Account() {
        id = ++init;
    }

    public Account(String password, double balance) {
        this.password = password;
        this.balance = balance;
        id = ++init;
    }

    public static void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public static double getMiniMoney() {
        return MiniMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        account.setPassword("123334");
        System.out.println(account);


        Account account1 = new Account();
        account1.setPassword("3000");
        account1.setBalance(200);
        System.out.println(account1);
    }
}
