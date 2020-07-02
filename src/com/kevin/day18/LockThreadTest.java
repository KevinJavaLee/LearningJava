package com.kevin.day18;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-15-17:43
 */
public class LockThreadTest implements Runnable {

    public static void main(String[] args) {
        LockThreadTest lockThreadTest = new LockThreadTest();
        Thread thread = new Thread(lockThreadTest);
        Thread thread1 = new Thread(lockThreadTest);
        Thread thread2 = new Thread(lockThreadTest);

        thread.setName("线程1");
        thread1.setName("线程2");
        thread2.setName("线程3");

        thread.start();
        thread1.start();
        thread2.start();

    }


    private ReentrantLock lock = new ReentrantLock();
    private int ticket = 100;

    @Override
    public void run() {

        while (true) {
            //开始锁定
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":"+ticket);
                ticket--;
            }else{
                break;
            }
            lock.unlock();//开始解锁
        }
    }
}
