package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-15-9:31
 */
public class CaseRunnable implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new CaseRunnable());
        thread.setName("线程1");
        thread.start();

        Thread thread1 = new Thread(new CaseRunnable());
        thread1.setName("线程2");
        thread1.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if (Thread.currentThread().getName().equals("线程1")) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);

                }
            } else if (Thread.currentThread().getName().equals("线程2")) {
                if (i % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }
    }
}
