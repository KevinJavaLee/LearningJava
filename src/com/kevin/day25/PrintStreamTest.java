package com.kevin.day25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-23-20:15
 */


public class PrintStreamTest {
    public static void main(String[] args)  {

        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("io.txt"));

            //打印流 自动刷新
            printStream = new PrintStream(fileOutputStream,true);

            int cnt = 0;
            for (int i = 0; i < 255 ; i++) {
                cnt++;
                if (cnt % 50 == 0) {
                    printStream.println();
                }
                printStream.print((char)i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (printStream != null) {
                printStream.close();
            }

        }



    }
}
