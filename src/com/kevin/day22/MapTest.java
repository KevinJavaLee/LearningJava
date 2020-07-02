package com.kevin.day22;

import org.junit.Test;

import java.util.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-19-16:16
 */



public class MapTest {

    @Test
    public void test() {
        //添加、删除、修改操作
        //put putAll() remove() clear()
        HashMap hashMap = new HashMap();
        hashMap.put(123, "匡总");
        hashMap.put(456, "小匡");
        hashMap.put(789, "大匡");
        hashMap.put(889, "中匡");
        System.out.println(hashMap);
        //putAll()
        HashMap hashMap1 = new HashMap();
        hashMap1.put(5666, "白匡");
        hashMap1.put(123, "匡总");
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);
        //remove()移除指定的key-value,并返回true
        System.out.println(hashMap.remove(123));
        //元素数据的查询功能
        hashMap.put(145, new Person("小匡", 123));
        Person p = (Person) hashMap.get(145);
        System.out.println(p);
        System.out.println(hashMap.containsKey(456));
        System.out.println(hashMap.containsKey(new Integer(123)));
        System.out.println(hashMap.containsValue("小匡"));
        hashMap.clear();//清空hashMap()
        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
    }

    @Test
    public void test2() {
        //遍历hashMap()
        HashMap hashMap = new HashMap();
        hashMap.put(123, "匡总");
        hashMap.put(456, "小匡");
        hashMap.put(789, "大匡");
        hashMap.put(889, "中匡");
        //遍历key
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        //遍历每一个key
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");
        //遍历value
        Collection values = hashMap.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        //遍历Entry
        Set set1 = hashMap.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();

//            System.out.println(iterator2.next());
        }


    }


    @Test
    public void test3() {
        //linkedHashMap适合反复的遍历
        HashMap hashMap = new LinkedHashMap();
        hashMap.put(123, "匡总");
        hashMap.put(456, "小匡");
        hashMap.put(789, "大匡");
        hashMap.put(889, "中匡");
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        for (Object o : set) {
            System.out.println(o);
        }

        System.out.println(hashMap);
    }

    @Test
    public void test4() {
        //自然排序定制排序
        TreeMap map = new TreeMap();
        map.put(new Person("小匡", 23), 1);
        map.put(new Person("大匡", 23), 1);
        map.put(new Person("中匡", 23), 1);
        map.put(new Person("白匡", 23), 1);
        System.out.println(map);

    }

    @Test
    public void test5() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;

                    return p1.getAge().compareTo(p2.getAge());
                }else{
                    throw new RuntimeException("出现异常");
                }

            }
        };
        TreeMap map = new TreeMap(comparator);
        map.put(new Person("小匡", 29), 1);
        map.put(new Person("大匡", 24), 2);
        map.put(new Person("中匡", 27), 3);
        map.put(new Person("白匡", 26), 4);
        System.out.println(map);



    }
}
