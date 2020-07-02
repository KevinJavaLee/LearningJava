package com.kevin.day29;

import com.kevin.day29.Example.Employee;
import com.kevin.day29.Example.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-07-01-9:18
 */
public class StreamApiTest1 {

    @Test
    public void test() {
        //3.排序
        //1.sorted()自然排序
        List<Employee> employees = EmployeeData.getEmployees();
        List<Integer> list = Arrays.asList(12, 0, 9, 23, 22, 45);
        Stream<Integer> sorted = list.stream().sorted();
        sorted.forEach(x -> System.out.print(x +" "));
//        System.out.println(sorted);
        System.out.println("---------------------------------");
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                return Integer.compare(o1.getAge(),o2.getAge());
            }
        };
        //2.
//        Stream<Employee> sorted1 = employees.stream().sorted(comparator);
        //改为Lambda表达式
        Stream<Employee> sorted1 = employees.stream().sorted((o1,o2)-> Integer.compare(o1.getAge(),o2.getAge()));

        sorted1.forEach(System.out::println);

    }



}
