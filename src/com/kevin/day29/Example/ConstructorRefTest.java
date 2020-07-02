package com.kevin.day29.Example;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *
 * 二、数组引用
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> supplier = () -> new Employee();
        Employee employee = supplier.get();
        System.out.println(employee);
        System.out.println("-------------------------");
        Supplier<Employee> emp = Employee::new;
        System.out.println(emp.get());
    }

	//Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer, Employee> function = e -> new Employee(e);
        Employee apply = function.apply(1001);
        System.out.println(apply);
        System.out.println("_____________________________");
        Function<Integer,Employee> function1 = Employee::new;
        System.out.println(function1.apply(1005));

    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> biFunction = (i,s)-> new Employee(i, s);
        Employee emp = biFunction.apply(1009, "匡总");
        System.out.println(emp);
        System.out.println("----------------------------");
        //改用引用调用构造方法
        BiFunction<Integer,String,Employee> biFunction1 = Employee::new;
        System.out.println(biFunction1.apply(1008, "晓宇"));
    }

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){

        //返回数组
        Function<Integer, Integer[]> function = (n) -> new Integer[n];
        Integer[] apply = function.apply(10);
        System.out.println(Arrays.toString(apply));
        System.out.println("-------------------------");
        //改用数组引用
        Function<Integer,Integer[]> integerFunction = Integer[]::new;
        Integer[] apply1 = integerFunction.apply(5);
        System.out.println(Arrays.toString(apply1));

    }
}
