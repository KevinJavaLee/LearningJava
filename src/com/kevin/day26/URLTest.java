package com.kevin.day26;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-10:00
 */
public class URLTest {


    //把网络资源储存到本地
    @Test
    public void test()  {

        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL("http://localhost:8090/03.jpg");

            //打开连接
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //建立连接
            urlConnection.connect();
            //得到输入流
            inputStream = urlConnection.getInputStream();
            //输出流
            fileOutputStream = new FileOutputStream(new File("kevin.jpg"));

            int len = 0;
            byte[] buffer = new byte[1024];

            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }



        }

    }
}
