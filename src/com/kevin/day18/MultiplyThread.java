package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-14-10:25
 */
 class MultiplyThread extends Thread {

    //多线程输出一千以内的质数
    @Override
    public void run() {
        for (int i = 2; i < 1000 ; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MultiplyThread1 extends Thread {

    //多线程输出一千以内的质数
    @Override
    public void run() {
        for (int i = 2; i < 1000 ; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


class ThreadDemo{

    public static void main(String[] args) {
        //调用多个线程
        MultiplyThread m1 = new MultiplyThread();
        m1.start();

        MultiplyThread1 m2 = new MultiplyThread1();
        m2.start();


        //
        for (int i = 2; i < 1000 ; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}



