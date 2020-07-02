package com.kevin.day29;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-30-10:04
 */
public class LambdaTest {


    //从匿名类到Lambada的转换
    @Test
    public void test() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匡总牛逼，正在学习Lambda表达式");
            }
        };
        //调用run方法
        runnable.run();
        System.out.println("____________________________________");
        //改用Lambda表达式
        Runnable runnable1 = ()-> System.out.println("匡总牛逼");
        runnable1.run();
    }

    @Test
    public void test1() {
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        treeSet.add("kuangz");
        treeSet.add("auangz");
        treeSet.add("suangz");
        treeSet.add("guangz");
        System.out.println(treeSet);
        System.out.println("————————————————————————————————————");
        //改用Lambda表达式
        TreeSet<String> treeSet1 = new TreeSet<>((o1,o2)-> o1.compareTo(o2)
        );
        treeSet1.add("kuangz");
        treeSet1.add("auangz");
        treeSet1.add("suangz");
        treeSet1.add("guangz");
        System.out.println(treeSet1);

    }

    @Test
    public void test3() {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1- o2;
            }
        };

        int compare = comparator.compare(1, 3);
        System.out.println(compare);
        System.out.println("-----------------------------");
        Comparator<Integer> comparator1 = (o1,o2) -> o1 - o2;
        int compare1 = comparator1.compare(4, 5);
        System.out.println(compare1);
    }
}
