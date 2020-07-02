package com.kevin.day25;

import java.io.File;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-21-9:52
 */
public class ExerciseTest {

    public static void main(String[] args) {
        //方式一：
//        File file = new File("C:\\Users\\jyw\\Pictures");
//        //
//        String[] list = file.list();
//        String picName = null;
//        int startIndex = 0;
//        for (String s : list) {
//            if (s.endsWith(".jpg")) {
//                startIndex = s.indexOf(".jpg");
//                picName = s.substring(0,startIndex);
//                System.out.println(picName);
//            }
//
//        }
//        File file = new File("E:\\ABT");
        long l = test1("E:\\BaiduNetdiskDownload");
        long by = l%1024;
        long kb = l/1024%1024;
        long mb = l/1024/1024%1024;
        long GB = l/1024/1024/1024;
        System.out.println(l);
        System.out.println(GB+ "GB" + mb + "MB" + kb + "KB" + by + "Byte");

    }

    public static void test(String path) {
        long len = 0;
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file1 : files) {

            if (file1.isDirectory()) {
                test(path+"\\"+file1.getName());
            }else {
                System.out.println(file1.getName());

            }
        }


    }

    public static long test1(String pathName) {
        long size = 0;
        File file = new File(pathName);

        if (file.isFile()) {
            size += file.length();
        }else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                size += test1(pathName + "\\" +file1.getName());
            }
        }
        return size;
    }
}
