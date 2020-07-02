package com.kevin.day28;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-28-8:10
 */
public class TestClass {

    //理解class类并获得class类的实例
    //获得class实例的四种方法

    @Test
    public void test() {

        //方法一：调用运行时类的
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //方法二：调用某个类的实例
        Person p1 = new Person();
        Class<? extends Person> aClass = p1.getClass();
        System.out.println(aClass);

        //方法三：调用运行时类forName()
        String string = "com.kevin.day28.Person";
        Class<?> aClass1 = null;
        try {
            aClass1 = Class.forName(string);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass1);

        //方法四：调用运行时类的
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            Class<?> aClass2 = classLoader.loadClass("com.kevin.day28.Person");
            System.out.println(aClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //那些类型可以有Class对象
    //class:外部类 、成员类（成员内部类，静态内部类），局部内部类，匿名内部类
    //接口数组、枚举、注解、基本数据类型、void
    @Test
    public void test2() {
        //理解类加载器的过程--
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader);

        //类加载器的父类--扩展类加载器
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        //引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

    }

    //类加载器加载文件
    @Test
    public void test3() throws Exception {

        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("kuang.properties");
        //加载输入流
//        properties.load(inputStream);

        //输出数据
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        System.out.println(user);
//        System.out.println(password);
        //方式二：
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("kuang.properties");
        properties.load(resourceAsStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user);
        System.out.println(password);


    }
}
