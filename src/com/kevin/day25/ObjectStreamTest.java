package com.kevin.day25;

import org.junit.Test;

import java.io.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-23-20:22
 */
public class ObjectStreamTest {

    @Test
    public void test()  {


        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("object.bat"));

            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(new String("匡总牛逼"));
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


        //关闭对象流

    }

    @Test
    public void testObjectStream()  {


        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.bat"));


            try {
                Object o = objectInputStream.readObject();
                System.out.println(o);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
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
