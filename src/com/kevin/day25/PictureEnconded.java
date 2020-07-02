package com.kevin.day25;

import org.junit.Test;

import java.io.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-21-20:48
 */


public class PictureEnconded {


    @Test
    public void test()  {
        //
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("10.jpg")));
            bufferedOutputStream = new BufferedOutputStream((new FileOutputStream(new File("02.jpg"))));

            byte[] buffer = new byte[10];

            int len = 0;
            while ((len = bufferedInputStream.read(buffer)) != -1) {

                for (int i = 0; i < len ; i++) {
                    buffer[i] =(byte) (buffer[i] ^ 5);

                }
                bufferedOutputStream.write(buffer,0,len);

            }
            //3.

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
