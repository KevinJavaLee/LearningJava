package com.kevin.day18.exercise;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-15-21:04
 */


public class Acccount {

    private double balance;
    //空构造函数
    public Acccount() {

    }

    //存钱的方法 每次存取元 方式二 同步方法
    public  void save(double money) {

        if (money > 0) {
            balance = balance + money;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存款成功！余额为：" + balance);
        }

    }

    //
}

class custorm extends Thread {

    private static ReentrantLock lock = new ReentrantLock();
    private Acccount acccount;

    public custorm(Acccount acccount) {
        this.acccount = acccount;
    }

    //同步代码块
    @Override
    public void run() {
        //同步代码块 方式一
//        synchronized (custorm.class) {
            //方式三：
            lock.lock();
            for (int i = 0; i < 3; i++) {

                acccount.save(1000);
            }
            lock.unlock();
//        }


    }
}


 class AccountTest {
     public static void main(String[] args) {
         Acccount acccount = new Acccount();
         custorm c1 = new custorm(acccount);
         custorm c2 = new custorm(acccount);
         c1.setName("甲");
         c2.setName("乙");

         c1.start();
         c2.start();
     }
}
