package com.kevin.day25;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-21-14:28
 */
public class FileReaderTest {


    @Test
    public void test()  {
        //方式一：
        FileReader fileReader = null;
        try {
            //1.创建文件类对象
            File file = new File("kevin.txt");


            //2.
            fileReader = new FileReader(file);

            int data = fileReader.read();
            while (data != -1) {
                System.out.print((char)data);
                data = fileReader.read();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭输出流
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果不存在则创建
//        if (!file.exists()) {
//
//            file.createNewFile();
//        }
    }

    @Test
    public void test1()  {
        FileReader fileReader = null;
        try {
            //方式二
            File file = new File("kevin.txt");
            fileReader = new FileReader(file);

            int len = 0;
            while ((len = fileReader.read()) != -1) {
                System.out.print((char)len);
            }
            //3.关闭输出流

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null)
            {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            //方式二
            File file = new File("kevin.txt");
            fileReader = new FileReader(file);

            //输入到数组中来输出
            char[] str = new char[5];

            int data ;

            while ( (data= fileReader.read(str)) !=-1) {

                for (int i = 0; i < data; i++) {
                    System.out.print(str[i]);
                }

            }

            //3.关闭输出流

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null)
            {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
