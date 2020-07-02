package com.kevin.day22;

import com.kevin.day13.Ourter;

import java.util.Objects;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-17-17:55
 */
public class Person  implements Comparable{

    private String name;
    private Integer age;

    Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用equals---------");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int cnt = 0;
        if (o instanceof Person) {
            Person person =(Person)o;
            cnt = this.name.compareTo(person.name);
            if (cnt == 0){
                return this.age.compareTo(person.age);
            }else {
                return cnt;
            }

        }else {
            throw new RuntimeException("出现异常");
        }

    }
}
