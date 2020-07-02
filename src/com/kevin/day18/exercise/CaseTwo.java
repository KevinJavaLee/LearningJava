package com.kevin.day18.exercise;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-15-21:38
 */


/*
* 线程通信的三个方法：
* 1.wait()
* 2.notify()//一旦执行会唤醒一个被执行的wait()线程
* 3.notifyAll()//一旦执行会唤醒所有的wait()程序
* 定义在java.lang.Object类中
*三个方法的调用者必须是同步代码块中的同步监视器
* 线程通信必须在同步代码块或者同步方法内才有效
*
*
* sleep()和wait的区别和相同点：
*
* */
public class CaseTwo implements Runnable {


    private  int num = 1;
    //线程通信必须放在同步代码块中来进行
    @Override
    public void run() {
        synchronized (this) {
            while (true) {

                notify();
                if (num <= 100) {
                    //唤醒线程
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;

                    //调永wait()方法后，线程进入阻塞状态
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                else {
                    break;
                }
            }

        }

    }
}

class CaseDemo{
    public static void main(String[] args) {
        CaseTwo caseTwo = new CaseTwo();
//        CaseTwo caseTwo1 = new CaseTwo();
        Thread thread = new Thread(caseTwo);
        Thread thread1 = new Thread(caseTwo);
        thread.setName("线程一");
        thread1.setName("线程二");

        thread.start();
        thread1.start();
    }
}

