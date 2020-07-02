package com.kevin.day25;

import org.junit.Test;

import java.io.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-21-20:09
 */


public class FileStreamTest {


    public void test() {

        BufferedInputStream bf = null;
        BufferedOutputStream outputStream = null;
        //缓冲流
        try {
            bf = new BufferedInputStream(new FileInputStream(new File("video.avi")));
            outputStream = new BufferedOutputStream(new FileOutputStream(new File("video1.avi")));

            byte[] buffer = new byte[1024];

            int len = 0;
            while ((len = bf.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }

            //3.关闭缓冲流

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void testBufferedStream() {
        long startTime = System.currentTimeMillis();
        test();
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }


    @Test
    public void testBufferStream() {

        FileInputStream inputStream = null;
        FileOutputStream OutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //创建File类对象
            File file = new File("dbcp.txt");
            File file1 = new File("db1.txt");

            //创建输入输出流
            inputStream = new FileInputStream(file);
            OutputStream = new FileOutputStream(file1);

            //创建缓冲流对象
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(OutputStream);

            byte[] buffer = new byte[10];

            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }

            //关闭四个对象
            //先关闭缓冲流对象

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //在关闭输入输出流对象

            if (OutputStream != null) {
                try {
                    OutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test3() {




        FileReader inputStream = null;
        FileWriter OutputStream = null;
        BufferedReader bufferedInputStream = null;
        BufferedWriter bufferedOutputStream = null;

        try {
            //创建File类对象
            File file = new File("dbcp.txt");
            File file1 = new File("db.txt");

            //创建输入输出流
            inputStream = new FileReader(file);
            OutputStream = new FileWriter(file1);

            //创建缓冲流对象
            bufferedInputStream = new BufferedReader(inputStream);
            bufferedOutputStream = new BufferedWriter(OutputStream);

//            byte[] buffer = new byte[10];
            //方法readLine()的使用
            String str;
            while ((str = bufferedInputStream.readLine()) != null) {

                bufferedOutputStream.write(str);//以此写入一行的数据
                bufferedOutputStream.newLine();//写入行分隔符


            }

            //关闭四个对象
            //先关闭缓冲流对象

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //在关闭输入输出流对象

            if (OutputStream != null) {
                try {
                    OutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

}
