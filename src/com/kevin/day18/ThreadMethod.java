package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-14-20:44
 */



/*
* 线程常用的方法：
* 1.setName()设置线程的名字
* 2.yield()释放资源
* 3.sleep()//让线程休眠多少秒数后输出
* 4.join()让其他线程资源加入
* 5.setPriority()
*
*
* */
public class ThreadMethod extends Thread
{

    @Override
    public void run() {
        Thread.currentThread().setName("线程1");
        for (int i = 2; i < 1000 ; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }

            if (isFlag) {
                try {
                    sleep(10);
                    setPriority(MIN_PRIORITY);//设置线程的优先级
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
//            if (i  == 73) {
//                yield();//释放现在斩有的资源
//            }
//            if (i  == 73) {
//                yield();//释放现在斩有的资源
//            }
        }
    }
}

class ThreadMethodTest{
    public static void main(String[] args) {
        ThreadMethod threadMethod = new ThreadMethod();
        threadMethod.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
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
                System.out.println(Thread.currentThread().isAlive());//是否存活
                System.out.println(Thread.currentThread().isDaemon());
                System.out.println(Thread.currentThread().getState());
            }
            if (i == 73) {
                try {
                    threadMethod.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
