package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-15-9:06
 */

/*
* 多人共同抢票
*线程建立二：
* 1.定义子类实现Runnable接口
* 2.子类重写Runanbel接口的run()方法
* 3.通过Thread含参构造器创建线程对象
* 4.将Runnable接口的子类对象作为实际参数传递给Thread类的构造器
* 5.调用Thread对象的start()启动线程
* */
public class RunnableTest1 implements Runnable {
    private int ticket = 100;
//    Object obj = new Object();//共同锁 范式以
    @Override
    public void run() {

        while (true) {
            show();
        }


    }

    public synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
//                    Thread.sleep(10);
            ticket--;
        }
    }

    public static void main(String[] args) {
        RunnableTest1 runnableTest = new RunnableTest1();
        Thread thread = new Thread(runnableTest);
        Thread thread1 = new Thread(runnableTest);
        Thread thread2 = new Thread(runnableTest);
        thread.setName("窗口1");
        thread1.setName("窗口2");
        thread2.setName("窗口3");
        thread.start();
        thread1.start();
        thread2.start();


    }
}
