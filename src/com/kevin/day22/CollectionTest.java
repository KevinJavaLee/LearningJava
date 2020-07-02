package com.kevin.day22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-17-17:49
 */
public class CollectionTest {


    @Test
    public void testMethod() {
        /*
        * 测试方法：
        * 1.add()
        * 2.addAll()
        * 3.clear()
        * */
        Collection c = new ArrayList();
        c.add("123");
        c.add("匡总牛逼啊");
        c.add(123);//自动装箱
        c.add(456);

        Collection c1 = new ArrayList();
        c1.add(new Person("匡总",12));//需要Person类中重写toString()方法输出
        c1.addAll(c);
        System.out.println("c的大小" + c.size());
        System.out.println("c1的大小" + c1.size());

        System.out.println(c);
        System.out.println(c1);

    }


    @Test
    public void testMethod1() {

        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(new String("匡总牛逼"));
        collection.add(new Person("晓宇", 22));
        collection.add(new Person("飞机匡", 23));


        System.out.println(collection.contains("匡总牛逼"));
        System.out.println(collection.contains(new Person("晓宇",22)));
        System.out.println(collection.contains(new Person("晓宇",23)));

        System.out.println(collection.remove(new Person("晓宇",22)));
    }

    @Test
    public void testMethod2() {

        //集合转换为数组
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(new String("匡总牛逼"));
        collection.add(new Person("晓宇", 22));
        collection.add(new Person("飞机匡", 23));
        //遍历对象数组
        Object[] objects = collection.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        System.out.println("数组转换为集合");

        //数组元素转换为集合
        List<String> strings = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(strings);

        List ints = Arrays.asList(new int[]{123, 22});
        System.out.println(ints.size());
        System.out.println(ints);

        List<Integer> list = Arrays.asList(new Integer(123), new Integer(345));
        System.out.println(list.size());
        System.out.println(list);

    }
}
