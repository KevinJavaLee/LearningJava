package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-14-10:16
 */


/*
* 多线程的创建方式：
* 1.定义类继承Thread
* 2.重写run()方法，将要写的东西放在run()方法中
* 3.创建该类的对象调用start()方法启动线程
*
* */
public class MyThread extends Thread {

    @Override
    public void run() {
        //输出100之内的偶数
        for (int i = 1; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class ThreadTest{
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        //主程序线程
        for (int i = 1; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

