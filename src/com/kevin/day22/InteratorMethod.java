package com.kevin.day22;

import sun.security.util.AuthResources_it;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-18-11:31
 */



public class InteratorMethod {

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(789);
        collection.add(new Person("晓宇", 22));
        collection.add(new String("匡总牛逼"));

        Iterator iterator = collection.iterator();
        //遍历集合 方式一
        Iterator iterator1 = collection.iterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());


        }


        System.out.println("_________________________");
        //删除集合中的元素

        int cnt = 0;
        while (iterator1.hasNext()) {
            cnt++;
            iterator1.next();
            if (cnt==2) {
                System.out.println("匡总牛逼呀");
                iterator1.remove();
            }

        }

        System.out.println("-----------------------");
        //增强for循环
        //增加for循环并不改变集合中的元素，只是把元素去出来
        for (Object obj : collection) {
            System.out.println(obj);
        }



    }
}
