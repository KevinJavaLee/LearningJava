package com.kevin.day22;

import org.junit.Test;

import java.util.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-19-20:08
 */


public class CollectionsTest {

    @Test
    public void test() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add(100);
        list.add("匡总牛逼");
        //反转List中元素的排序
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        //对List集合进行随机排序
        Collections.shuffle(list);
        System.out.println(list);
        //
    }

    @Test
    public void test1(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return p1.getName().compareTo(p2.getName());

                }
                return 0;
            }
        };
        ArrayList list = new ArrayList();
        list.add(new Person("liudehua",23));
        list.add(new Person("wang",24));
        list.add(new Person("li",34));
        list.add(new Person("chan",45));
        list.add(new Person("bell",34));

        Collections.sort(list,comparator);
        System.out.println(list);
        Collections.swap(list,0,2);
        System.out.println(list);

    }

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add(245);
        list.add(345);
        list.add(445);
        System.out.println(list);
        //一种方式
        List list1 = Arrays.asList(new Object[list.size()]);
        Collections.copy(list1, list);
        System.out.println(list1);
    }

}
