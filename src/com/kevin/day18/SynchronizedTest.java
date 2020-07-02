package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-15-11:13
 */



public class SynchronizedTest extends Thread {

    //使用同步代码块的问题来解决线程的安全问题
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
//            synchronized (SynchronizedTest.class) {
//                try {
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
//                    ticket--;
//                }
//            }


        }
    }

    public static synchronized void show(){
           try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                }
    }


    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        SynchronizedTest synchronizedTest2 = new SynchronizedTest();
        synchronizedTest.setName("窗口1");
        synchronizedTest1.setName("窗口2");
        synchronizedTest2.setName("窗口3");

        synchronizedTest.start();
        synchronizedTest1.start();
        synchronizedTest2.start();

    }
}
