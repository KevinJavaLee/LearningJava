package com.kevin.day25;

import org.junit.Test;

import java.io.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-21-16:16
 */
public class FileInputStreamTest {

    public static void main(String[] args) {
        String srcPath = "D:\\BaiduNetdiskDownload\\30天java基础全套视频\\day26_IO流\\05-尚硅谷-Java语言高级-IO流概述与流的分类.avi";
        String destPath = "video.avi";
        long startTime = System.currentTimeMillis();
        copyFile(srcPath,destPath);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void test() throws Exception {


        FileInputStream inputStream = null;
        try {
            //1.创建File对象，指明读取数据的路径
            File file = new File("kevin.txt");
            //2.
            inputStream = new FileInputStream(file);

            byte[] str = new byte[5];
            //3.
            int len = 0;
            while ((len = inputStream.read(str)) != -1) {
                String content = new String(str, 0, len);
                System.out.print(content);
            }
            //4.关闭

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }

    }


    //复制文件
    public static void copyFile(String srcPath, String destPath) {

        FileInputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            File file = new File(srcPath);
            File file1 = new File(destPath);

            inputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);

            //读取文件数据

            byte[] buffer = new byte[1024];

            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
