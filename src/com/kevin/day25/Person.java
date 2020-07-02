package com.kevin.day25;

import java.io.Serializable;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-23-21:33
 */

//序列对对象要实现Serializable接口
public class Person implements Serializable {

    //定义序列化版本号
    private static final long serialVersionUID = 670754667710L;

    private String name;
    private int age;


    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
