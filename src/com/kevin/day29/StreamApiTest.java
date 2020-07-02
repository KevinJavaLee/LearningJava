package com.kevin.day29;

import com.kevin.day29.Example.Employee;
import com.kevin.day29.Example.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-30-21:44
 */
public class StreamApiTest {


    @Test
    public void test() {
        //提供获取流的方法
        //通过数组创建流的实例
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employees.parallelStream();
        Stream<Employee> stream = employees.stream();
        System.out.println(stream);
        //2.通过数组创建流
        int[] arr = new int[]{1, 3, 6, 0, 33, 33};
        IntStream stream1 = Arrays.stream(arr);
        System.out.println(stream1);
        //3.通过Stream的of方法来创建流
        Stream<List<Employee>> employees1 = Stream.of(employees);
        System.out.println(employees1);
        //4.创建无限

    }

    //筛选与切片
    @Test
    public void test2() {
        //1.filter() 接收lambda从流中排除某些元素
        //
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        Predicate<Employee> employeePredicate = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 6000;
            }
        };
        //改用Lambda表达式
//        stream.filter(employeePredicate).forEach(System.out::println);
        stream.filter(e -> e.getSalary() > 6000).forEach(System.out::println);
        System.out.println("------------------------");
        //2.limit()截断流，使元素不超过给定数量
        employees.stream().limit(3).forEach(System.out::println);
        //3.distinct()取出重复的元素
        System.out.println("---------------------------");
        List<Employee> list = new ArrayList<>();
        Employee employee = new Employee(1009, "JackMa", 34, 5000);
        list.add(employee);
        list.add(employee);
        list.add(employee);
        list.add(employee);
        list.add(employee);
        list.add(employee);
        list.addAll(employees);
        Stream<Employee> stream1 = list.stream();

        stream1.distinct().forEach(x -> System.out.println(x));

    }

    //Stream的中间操作
    @Test
    public void test3() {

        //1.函数的映射
        //map(Function f)接收每个函数参数，将其映射成为新的函数
        List<Employee> employees = EmployeeData.getEmployees();
        List<String> strings = Arrays.asList("aa", "dd", "ee", "ff");
//        Function<String,String> function = new Function<String, String>() {
//            @Override
//            public String apply(String string) {
//                return string.toUpperCase() ;
//            }
//        };
        System.out.println("-------------------");

        strings.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //获取员工名字长度大于三的员工
        //得到所有的员工的姓名
        //方法的引用
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        //通过过滤器
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);

    }
    @Test
    public void test4(){
        List<String> strings = Arrays.asList("aa", "dd", "ee", "ff");
        Stream<Stream<Character>> streamStream = strings.stream().map(StreamApiTest::fromStringToStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });
        System.out.println("-----------------------------");

        //flatMap()接收一个函数作为参数，将流中的每个值都转换为另外一个流i
        Stream<Character> characterStream = strings.stream().flatMap(StreamApiTest::fromStringToStream);
        characterStream.forEach(System.out::println);

//        Stream<Character> characterStream = fromStringToStream("addgg");
//        characterStream.forEach(System.out::println);
    }


    //
    public static Stream<Character> fromStringToStream(String string) {
        ArrayList<Character> arrayList = new ArrayList<>();
        for (Character c : string.toCharArray()) {
            arrayList.add(c);
        }

        //返回字符流
        return arrayList.stream();
    }


}
