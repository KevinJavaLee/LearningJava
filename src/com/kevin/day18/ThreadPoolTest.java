package com.kevin.day18;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-16-11:26
 */

class NewThread implements Runnable {

    @Override
    public void run() {


        for (int i = 2; i < 1000; i++) {
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i) ; j++) {

                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }
}


public class ThreadPoolTest {

    public static void main(String[] args) {
        //线程池的使用
        //创建一个可重用固定线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);



        //运行一个实现Runable接口的类对象
        executorService.submit(new NewThread());
        //运行一个实现Callable接口类的对象
        Object sum = executorService.submit(new CallableThread());
        System.out.println(executorService.getClass());
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
//        threadPoolExecutor.setKeepAliveTime();
        System.out.println(threadPoolExecutor.getLargestPoolSize());
        System.out.println(threadPoolExecutor.getActiveCount());
        System.out.println(threadPoolExecutor.getCorePoolSize());


        //关闭线程池
        executorService.shutdown();


    }

}
