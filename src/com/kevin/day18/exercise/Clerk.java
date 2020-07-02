package com.kevin.day18.exercise;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-16-16:51
 */


public class Clerk {
    //共享数据
    private static int product = 0;

    Clerk() {

    }

    public synchronized void produce() {
        if (product >= 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            product++;
            System.out.println(Thread.currentThread().getName() + "生产了产品:"+product);
            notify();

        }
    }

    public synchronized void reduce() {

        if (product <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + "消耗了产品：" + product);
            product--;
            notify();
        }
    }



}

class Productor extends Thread{

    Clerk clerk ;


    Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    //作为生产者
    @Override
    public void run() {
        //生产产品
        try {

            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            clerk.produce();
        }


    }
}

class Custormer extends Thread {

    Clerk clerk;

    Custormer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.reduce();
        }
        //消耗产品


    }
}

class ClerkTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        //new Productor(clerk).setName("生产者");
        Productor productor = new Productor(clerk);
        productor.setName("生产者");
        productor.start();
        //new Custormer(clerk).setName("消费者");
        Custormer custormer = new Custormer(clerk);
        custormer.setName("消费者");
        custormer.start();
        Custormer custormer1 = new Custormer(clerk);
        custormer1.setName("消费者1");
        custormer1.start();

        Custormer custormer2 = new Custormer(clerk);
        custormer2.setName("消费者2");
        custormer2.start();
    }
}


