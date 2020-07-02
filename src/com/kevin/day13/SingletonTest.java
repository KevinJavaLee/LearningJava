package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-12-9:20
 */


/**
*
* 单例模式：饿汉式
 *
*
* */
public class SingletonTest {

    public static void main(String[] args) {
        Bank bank = Bank.getBankInstance();
        Bank bank1 = Bank.getBankInstance();

        System.out.println(bank == bank1);
    }
}

class Bank{

    //声明为私有方法不能够创建对象
    private Bank() {

    }

   private static Bank bank = new Bank();


    public static Bank getBankInstance() {
        return bank;
    }
}


