package com.kevin.day29.Example;

import com.kevin.day25.PrintStreamTest;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * Created by shkstart.
 */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	@Test
	public void test1() {

		System.out.println("_______________________");
		Consumer<String> consumer1 = t -> System.out.println(t);
		consumer1.accept("匡总牛逼！");
		System.out.println("_______________________");
		PrintStream ps = new PrintStream(System.out);
		Consumer<String> consumer = ps::println;
		consumer.accept("晓宇牛逼");
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	@Test
	public void test2() {
		Employee employee = new Employee(1001,"匡总");
		Supplier<String> supplier = () -> employee.getName();
		String s = supplier.get();
		System.out.println(s);
		System.out.println(employee);
		System.out.println("______________________");
		Employee employee1 = new Employee(1003, "渔村");
		Supplier<String> stringSupplier = employee1::getName;
		String s1 = stringSupplier.get();
		System.out.println(s1);


	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
		int compare = comparator.compare(12, 34);
		System.out.println(compare);
		//改为方法的引用
		System.out.println("---------------------------");
		Comparator<Integer> comparator1 = Integer::compare;
		System.out.println(comparator1.compare(23, 12));

	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> function = (d) -> Math.round(d);
		System.out.println(function.apply(12.3));
		System.out.println("-----------------------");
		//改用方法的引用 静态方法--- 类::静态方法
		Function<Double,Long> function1 = Math::round;
		System.out.println(function1.apply(13.6));

	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> comparator = (t1, t2) -> t1.compareTo(t2);
		int compare = comparator.compare("abc", "abe");
		System.out.println(compare);
		System.out.println("_____________");
		//改用方法的引用
		Comparator<String> comparator1 = String::compareTo;
		System.out.println(comparator1.compare("abd", "abc"));
	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		//1.选用lambda表达式
		BiPredicate<String, String> biPredicate = (t1, t2) -> t1.equals(t2);
		boolean test = biPredicate.test("abc", "abc");
		System.out.println(test);
		System.out.println("_______________________");
		//改用方法的引用
		BiPredicate<String,String> biPredicate1 = String::equals;
		System.out.println(biPredicate.test("agc", "agd"));

	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee employee = new Employee(1005, "萝卜");
		Function<Employee,String> function = e -> e.getName();
		String apply = function.apply(employee);
		System.out.println(apply);
		System.out.println("_________________");

		//改用方法的引用
		Function<Employee,String> emp = Employee::getName;
		System.out.println(emp.apply(employee));
	}

}
