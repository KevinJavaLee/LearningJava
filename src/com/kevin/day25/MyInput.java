package com.kevin.day25;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-23-17:52
 */
public class MyInput {
    static String str = null;
    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        System.out.println("请输入数据：");
        str = bufferedReader.readLine();

        System.out.println(nextInt(str));


    }

    public static int nextInt(String string) {
        return Integer.parseInt(string);
    }

    public static double nextDouble(String string) {
        return Double.parseDouble(string);
    }

    public static float nextFloat(String string) {
        return Float.parseFloat(string);
    }

    public static boolean nextBoolean(String string){
        return Boolean.getBoolean(string);
    }

    public static byte nextByte(String string) {
        return Byte.parseByte(string);
    }

    public static short nextShort(String string){
        return Short.parseShort(string);
    }




}
