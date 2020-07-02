package com.kevin.day29;

import com.kevin.day29.Example.Employee;
import com.kevin.day29.Example.EmployeeData;
import org.junit.Test;
import sun.security.util.AuthResources_it;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-07-01-9:29
 */
public class StreamAPITest2 {


    //Stream()的终止操作
    @Test
    public void test(){
        List<Employee> employees = EmployeeData.getEmployees();
        //1.allMatch()检查是否所有的元素都匹配
        Predicate<Employee> employeePredicate = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getName().length() > 3;
            }
        };
        boolean b = employees.stream().allMatch(e -> e.getName().length() > 3);
        System.out.println(b);
        System.out.println("___________________");
        //2.anyMatch()检查是否至少匹配一个元素
        boolean isFlag = employees.stream().anyMatch(e -> e.getName().contains("雷"));
        System.out.println(isFlag);
        System.out.println("-------------------");
        //noneMatch()
        boolean b1 = employees.stream().noneMatch(e -> e.getAge() > 12);
        System.out.println(b1);
        System.out.println("--------------------");
        //findFirst()返回当前流中的任意元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //findAny()返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
    }


    //终止操作二：
    @Test
    public void test1() {

        List<Employee> employees = EmployeeData.getEmployees();
        //count()返回流中的元素总和
        long count = employees.stream().count();
        System.out.println(count);
        //返回流中元素的最大值
        List<Integer> list = Arrays.asList(12, 3, 44, 78, 56, 99);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
//        Optional<Integer> max = list.stream().max((o1,o2) -> Integer.compare(o1,o2));
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(max);
        System.out.println(min);

    }

    @Test
    public void test3() {

        List<Employee> employees = EmployeeData.getEmployees();
        List<Integer> list = Arrays.asList(12, 33, 44, 55, 1, 33, 67);

        //计算机1-10自然数的和
        //1.规约
        //reduce()将流中的元素反复结合起来得到一个值
        BinaryOperator<Integer> tBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer t1, Integer t2) {
                return Integer.sum(t1,t2);
            }
        };
//        Optional<Integer> reduce = list.stream().reduce(tBinaryOperator);
        //采用方法引用的方法
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println(reduce);
        //计算公司所有员工的工资之和
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        System.out.println(reduce1);
    }

    //
    @Test
    public void test4() {

        //Collector对流执行收集的操作
        List<Employee> employees = EmployeeData.getEmployees();
        //得到工资大于5000的人
        Stream<Employee> employeeStream = employees.stream().filter(e -> e.getSalary() > 5000);
        //将流转换伟列表的操作
        List<Employee> collect = employeeStream.collect(Collectors.toList());
        System.out.println(collect);
        //遍历集合
        for (Employee employee : collect) {
            System.out.println(employee);
        }
        System.out.println("---------------------------");
        Stream<Employee> employeeStream1 = employees.stream().filter(e -> e.getSalary() > 5000);
        //将流转换为set
        Set<Employee> collect1 = employeeStream1.collect(Collectors.toSet());
        Iterator<Employee> iterator = collect.iterator();
        //迭代输出
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
