package com.kevin.day25;

import org.junit.Test;

import java.io.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-21-15:55
 */
public class FileWriterTest {


    @Test
    public void test()  {
        FileWriter fileWriter = null;
        //1.
        try {
            File file = new File("xiaoyu.txt");

             fileWriter = new FileWriter(file,true);

            String str = "\n匡总牛逼1";

            fileWriter.write(str);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    @Test
    public void test1()  {
        //换成图片是否可行
        //字符流只能处理字符数据
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //读写
            File file = new File("C:\\Users\\jyw\\Desktop\\图片\\2020-04-23_110545.png");
            File file1 = new File("D:\\java_projec\\Java30天核心技术\\pic.png");

             fr = new FileReader(file);
             //往文件中添加数据
             fw = new FileWriter(file1,true);

            char[] buffer = new char[5];
            //先读出数据
            int len = 0;

            while ((len = fr.read(buffer)) != -1) {
                fw.write(buffer,0,len);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
