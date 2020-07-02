package com.kevin.day28;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-29-11:56
 */
public class OtherTest {


    //1.获取全部的构造器
    @Test
    public void test() {

        Class<Human> creatureClass = Human.class;
        Constructor<?>[] constructors = creatureClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            //1.取得修饰符
            int modifiers = constructor.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2.输出名字
            String name = constructor.getName();
            System.out.print(name + "\t");

            //3.得到参数的类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType + "\t");
            }

            System.out.println();
        }

        System.out.println("--------------------------");
        //获取本类的所有的构造器
        Constructor<?>[] constructors1 = creatureClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors1) {
            //1.取得修饰符
            int modifiers = constructor.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2.输出名字
            String name = constructor.getName();
            System.out.print(name + "\t");

            //3.得到参数的类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType + "\t");
            }

            System.out.println();
        }
    }
    //2.所继承的父类

    @Test
    public void test2() {

        //得到该类的父类
        Class<Human> humanClass = Human.class;
        Class<? super Human> superclass = humanClass.getSuperclass();
        //返回父类的接口
        Class<?>[] interfaces = superclass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.print(interfaces + "\t");
        }
        System.out.println("-----------------");
        //返回父类的注解
        Annotation[] annotations = superclass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.print(annotation);
        }
        System.out.println("-------------------");
        System.out.println(superclass);


    }

    //3.全部注解
    @Test
    public void test3() {
        Class<Human> humanClass = Human.class;
        Annotation[] annotations = humanClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

    }


    //4.泛型

    //5.以及接口
    @Test
    public void test5() {
        //得到该类的包
        Class<Human> humanClass = Human.class;
        Package aPackage = humanClass.getPackage();
        System.out.println(aPackage);
    }
}
