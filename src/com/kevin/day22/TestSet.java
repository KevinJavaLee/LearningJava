package com.kevin.day22;

import org.junit.Test;
import sun.security.util.AuthResources_it;

import java.util.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-18-20:18
 */


/*
* Hashset()的集合判断两个元素相等的标准：两个对象通过Hashcode()方法比较相等，
* 并且两个对象的equals()方法返回值相等
*
* */

public class TestSet {


    @Test
    public void test1() {
        //set的实现
        //hashset()是set接口的经典的实现
        HashSet set = new HashSet();
        set.add(123);
        set.add(456);
        set.add(678);
        set.add(new Person("匡总", 23));
        set.add(new String("匡总牛逼"));
        set.add(new Person("匡总", 23));
        System.out.println(set);
    }

    @Test
    public void test2() {
        LinkedHashSet set = new LinkedHashSet();
        set.add(123);
        set.add(456);
        set.add(678);
        set.add(new Person("匡总", 23));
        set.add(new String("匡总牛逼"));
        set.add(new Person("匡总", 23));
        System.out.println(set);
    }

    @Test
    public void test3() {
        //TreeSet类中只能存储同种数据类型
        TreeSet set = new TreeSet();
        set.add(6777);
        set.add(123);
        set.add(456);
        set.add(789);
//        set.add(new String("匡总牛逼"));
        System.out.println(set);
    }

    @Test
    public void test4() {
        //自然排序
        TreeSet set = new TreeSet();
        set.add(new Person("匡总牛逼",23));
        set.add(new Person("晓宇牛逼",22));
        set.add(new Person("崔斯坦啊",22));
        set.add(new Person("崔斯坦啊",23));
        set.add(new Person("崔斯坦啊",23));
        set.add(new Person("崔斯坦啊",20));

        System.out.println(set);


    }

    @Test
    public void test5() {
        //定制排序
        //比较器
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    int compare = Integer.compare(p1.getAge(), p2.getAge());
                    if (compare == 0)
                    {
                        return p1.getName().compareTo(p2.getName());
                    }else {
                        return compare;
                    }

                }
                return 0;
            }
        };
        //自然排序
        TreeSet set = new TreeSet(comparator);
        set.add(new Person("匡总牛逼",23));
        set.add(new Person("晓宇牛逼",22));
        set.add(new Person("崔斯坦啊",24));
        set.add(new Person("崔斯坦啊",23));
        set.add(new Person("崔斯坦啊",25));

        System.out.println(set);


    }

    @Test
    public void testMethod1() {

        //定义Comparator
//        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                if (o1 instanceof Employee && o2 instanceof Employee) {
//                    Employee e1 = (Employee) o1;
//                    Employee e2 = (Employee) o2;
//                    int differYear = o1.getBirthday().getYear() - o2.getBirthday().getYear();
//
//                    if (differYear != 0) {
//                        return differYear;
//                    }
//
//                    int differMonth = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
//                    if (differMonth != 0) {
//                        return differMonth;
//                    }
//
//                    int differDay = o1.getBirthday().getDay() - o2.getBirthday().getDay();
//                    if (differDay != 0) {
//                        return differDay;
//                    }
//                }
//                return 0;
//            }
//        };



        TreeSet<Employee> treeSet = new TreeSet<>();
        treeSet.add(new Employee("liudehua", 56, new MyDate(1956, 5, 9)));
        treeSet.add(new Employee("zhangxueyou", 57, new MyDate(1955, 8, 9)));
        treeSet.add(new Employee("guofuchen", 46, new MyDate(1980, 4, 9)));
        treeSet.add(new Employee("liming", 66, new MyDate(1976, 2, 9)));
        treeSet.add(new Employee("wagnjie", 76, new MyDate(1946, 10, 9)));

        Iterator<Employee> iterator = treeSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }


    }
}
