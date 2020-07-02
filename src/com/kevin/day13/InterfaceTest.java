package com.kevin.day13;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-12-15:57
 */
public interface InterfaceTest {

    //java8中允许在接口中加入静态方法
    public static void method() {
        System.out.println("匡总牛逼");
    }

    default void method1(){
        System.out.println("匡总实在是太牛逼！");
    }

    public default  void method2() {
        System.out.println("匡总对非洲爱的深沉！");
    }
}


