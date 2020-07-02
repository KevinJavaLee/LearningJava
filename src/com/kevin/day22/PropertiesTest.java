package com.kevin.day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-20-8:59
 */



public class PropertiesTest {

    public static void main(String[] args) {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            //绝对路径
             inputStream = new FileInputStream("D:\\java_projec\\Java30天核心技术\\src\\com\\kevin\\day22\\jdbc.properties");
            properties.load(inputStream);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            System.out.println(username);
            System.out.println(password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
