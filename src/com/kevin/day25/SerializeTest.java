package com.kevin.day25;

import org.junit.Test;

import java.io.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-23-21:31
 */
public class SerializeTest {


    @Test
    public void testObjectSeriallize()  {

        //定义序列化对象
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.bat"));



            objectOutputStream.writeObject(new Person("晓宇", 22));
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person("渔村", 34));
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }


    @Test
    public void test2()  {


        //
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.bat"));
            //读取对象
            Object o = objectInputStream.readObject();
            Person o1 = (Person) o;

            Object o2 = objectInputStream.readObject();
            Person p2 = (Person) o2;

            System.out.println(o1);
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }
}
