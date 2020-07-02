package com.kevin.day29;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-30-10:43
 */
public class LambdaTest1 {

    //Lambda操作符：
    //左侧：指定了Lambda表达式所需的参数列表
    //右侧：指定了Lambda体，即Lambda表达式需要执行的功能
    @Test
    public void test() {
        //语法一：无参，无返回值
        Runnable runnable = () ->{
            System.out.println("匡总牛逼！");
        };
        runnable.run();
        System.out.println("-----------------");
        //需要一个参数，但是没有返回值
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("晓宇牛逼");
        //
        Consumer<String> consumer1 = (String str) ->{
            System.out.println(str);
        };
        consumer1.accept("渔村牛逼");
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = (x,y) ->{
            System.out.println("使用函数式接口");
            return Integer.compare(x, y);
        };

        int compare = comparator.compare(4, 0);
        System.out.println(compare);
    }
}
