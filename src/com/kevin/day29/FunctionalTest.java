package com.kevin.day29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-30-10:52
 */
public class FunctionalTest {


    public String toUpperString(MyNumber<String> myNumber, String string) {
        return myNumber.getValue(string);
    }

    @Test
    public void test() {
        String string = toUpperString((s) -> s.toUpperCase(), "adddd");
        System.out.println(string);
    }



    public void happyTime(Consumer<Double> con, double money) {
        con.accept(money);
    }

    //
    @Test
    public void test1(){
        happyTime(new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("匡总学习太累去天上人间买了瓶水，花了"+aDouble);
            }
        },1200);

        System.out.println("------------------------------------------------");
        happyTime((aDouble -> System.out.println("晓宇太累去和匡总喝水花了"+aDouble)),1500);

    }


    public List<String> filterStr(List<String> strings, Predicate<String> predicate) {
        ArrayList<String> list = new ArrayList<>();


        //增加for循环 遍历
        for (String string : strings) {
            if (predicate.test(string)) {
                list.add(string);
            }

        }
        return  list;
    }

    @Test
    public void test3() {

        List<String> strings = Arrays.asList("天津", "南京", "东京", "西京", "会靖");
        List<String> list = filterStr(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list);
        System.out.println("--------------------------------");
        List<String> list2 = filterStr(strings, (s) -> s.contains("京"));
        System.out.println(list2);
    }





}
