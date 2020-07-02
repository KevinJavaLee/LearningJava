package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-15-16:06
 */
public class SingleTonPattern {

    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
    }

}
class Bank{

    Bank() {

    }

    private static Bank instance = null;

    //懒汉模式的线程安全问题
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                    return instance;
                }

            }
        }
        return instance;

    }

}

