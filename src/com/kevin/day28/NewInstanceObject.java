package com.kevin.day28;

import org.junit.Test;

import java.util.Random;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-28-21:06
 */


public class NewInstanceObject {


    @Test
    public void test() throws IllegalAccessException, InstantiationException {


        //1.创建Person类运行实例
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        System.out.println(person);


    }


    @Test
    public void test4() throws Exception {
        Random random = new Random();
        int randNum = random.nextInt(3);
        String path = "";
        switch (randNum) {
            case 0:
                path = "com.kevin.day28.Person";
                break;
            case 1:
                path = "com.kevin.day28.Person";
                break;
            case 2:
                path = "com.kevin.day28.Creature";
                break;
        }
        Object instance = getInstance(path);
        System.out.println(instance);

    }

    public  Object getInstance(String classpath) throws Exception {
        Class<?> aClass = Class.forName(classpath);
        return aClass.newInstance();

    }

}
