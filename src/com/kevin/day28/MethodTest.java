package com.kevin.day28;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-29-11:38
 */
public class MethodTest {


    @Test
    public void testMethod(){
        //类额反射
//        Class<Human> humanClass = Human.class;
        Human human = new Human();
        Class<? extends Human> aClass = human.getClass();

        //调用此类及其父类的public方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {

            //1.访问权限
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2.返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType + "\t");

            //3.返回方法名
            String name = method.getName();
            System.out.print(name + "\t");
            //4.获得参数的类型
            System.out.print("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            int cnt = 0;
            for (Class<?> parameterType : parameterTypes) {
                cnt++;
                if (cnt == parameterTypes.length) {
                    System.out.print(parameterType );
                    break;
                }
                System.out.print(parameterType + ",");
            }

            System.out.print(")");
            //5.获取方法的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.print(exceptionType + "\t");
            }

            System.out.println();

        }

    }

    @Test
    public void testMethod1(){
        //类额反射
//        Class<Human> humanClass = Human.class;
        Human human = new Human();
        Class<? extends Human> aClass = human.getClass();

        //调用此类及的public方法
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {

            //1.访问权限
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2.返回值类型
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType + "\t");

            //3.返回方法名
            String name = method.getName();
            System.out.print(name + "\t");
            //4.获得参数的类型
            System.out.print("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            int cnt = 0;
            for (Class<?> parameterType : parameterTypes) {
                cnt++;
                if (cnt == parameterTypes.length) {
                    System.out.print(parameterType );
                    break;
                }
                System.out.print(parameterType + ",");
            }

            System.out.print(")");
            //5.获取方法的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.print(exceptionType + "\t");
            }

            System.out.println();

        }

    }



}
