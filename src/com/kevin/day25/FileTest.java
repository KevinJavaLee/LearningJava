package com.kevin.day25;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-20-19:46
 */



public class FileTest {


    @Test
    public void test() {
        //以路径为名创建File对象 可以为绝对路径和相对路径
        File file = new File("hello.txt");
        //取绝对路径
        File file1 = new File("D:\\java_projec\\Java30天核心技术\\hi.txt");
        System.out.println(file.getAbsolutePath());//得到绝对路径
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());//得到父类文件
        System.out.println(file.lastModified());//最后以此修改的时间
        System.out.println(file.length());//文件的长度
        System.out.println("-------------------");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.lastModified());//最后以此修改的时间
        System.out.println(file1.length());//求文件的长度

    }

    @Test
    public void test1() {

        File file = new File("D:\\java_projec");
        //获取目录下所有的文件和文件目录的名称数组
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
            
        }

        System.out.println("----------------------");
        File[] files = file.listFiles();
        for (File file1 : files) {
            String[] list1 = file1.list();
            for (String s : list1) {
                System.out.println(s);
            }
        }


    }

    @Test
    public void test3() {
        //路径
        File file = new File("D:\\java_projec");
        File file1 = new File("D:\\java_projec\\Java30天核心技术\\src\\com\\kevin\\day25\\kevin.txt");
        //1.判断文件是否存在
        System.out.println(file.exists());
        //2.是否是文件
        System.out.println(file.isFile());
        //3.是否是目录
        System.out.println(file.isDirectory());
        System.out.println("----------------");
        //4.如果文件存在，则不创建，不存在则创建，返回值类型boolean
        try {
            boolean newFile = file1.createNewFile();
            System.out.println(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test4() {
        //mkdir()  mkdirs()方法的使用
        File dir = new File("D:\\kuang\\dir");
        if (!dir.exists()) {
            //如果不存在则创建目录，存在则创建。上层目录不在也创建目录
            boolean mkdir = dir.mkdir();
            System.out.println(mkdir);
        }

        System.out.println("---------------");
        File file = new File("D:\\kuang\\dir");

        if (!file.exists()) {
            //上层目录不存在则一并创建
            boolean mkdirs = file.mkdirs();
            System.out.println(mkdirs);
        }

        System.out.println("----------------");
        File file1 = new File(file, "\\xiaoyu");
        if (!file1.exists()) {
            boolean mkdir = file1.mkdir();
            System.out.println(mkdir);

        }

        File file2 = new File(file1, "kevin.txt");
        if (!file2.exists()) {
            try {
                boolean newFile = file2.createNewFile();
                System.out.println(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
