package com.kevin.day28;

import java.io.Serializable;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-28-21:39
 */
public class Human extends Creature implements Serializable,Comparable,MyInterface {

    private String name;
    private int age;
    public String nation;
    public String interest;


    public Human() {

    }

    private Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, String nation) {

    }

    public String show(String nation) {
        System.out.println(name + "是" + nation + "人");
        return nation;
    }

    private String display(String interest) {
        return interest;
    }


    @Override
    public int compareTo(Object o) {

        if (o instanceof Human) {
            Human o1 = (Human) o;
            return name.compareTo(o1.name);
        }else{
            try {
                throw new Exception("抛出异常");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public void info() {
        System.out.println("匡总时一个非洲人");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", interest='" + interest + '\'' +
                '}';
    }
}
