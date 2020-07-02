package com.kevin.day18;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-16-11:13
 */


//多线程的实现方式三：
public class CallableThread implements Callable {

    //有返回值
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {

                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;

            }
        }

        return sum;
    }

    public static void main(String[] args) {
        //1.创建实现Callable接口的实现类对象
        CallableThread callableThread = new CallableThread();
        //2.创建FutureTask对象
        FutureTask task = new FutureTask(callableThread);
        //3.创建Threa对象
        Thread thread = new Thread(task);

        thread.setName("线程1");
        thread.start();

        //得到一个返回值
        try {
            System.out.println(Thread.currentThread().getName() + ":总和为：" + task.get());
//            task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
