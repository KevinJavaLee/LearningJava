package com.kevin.day18;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-14-10:35
 */
public class Anonymous {

    public static void main(String[] args) {
        //匿名线程1
        new Thread(){
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
        }.start();

        //主函数类
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
