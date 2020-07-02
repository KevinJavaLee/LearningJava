package com.kevin.day25;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-23-17:37
 */
public class CaseTest {

    public static void main(String[] args)  {
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader fileInputStream = new InputStreamReader(System.in);
            //
            bufferedReader = new BufferedReader(fileInputStream);

            String str = null;
            System.out.println("请输入数据：");
            while ((str = bufferedReader.readLine()) != null) {

                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                    System.out.println("结束！");
                    break;
                }

                //将读到的字符串转换为大写
                System.out.println(">>>" + str.toUpperCase());
                System.out.println("请重新输入数据：");

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //字节流转换为字符流



}
