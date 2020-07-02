package com.kevin.day25;

import org.junit.Test;

import java.io.*;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-23-11:41
 */


public class OtherStreamTest {


    @Test
    public void test() throws IOException {
        //字节流--->>字符流
        //输入输出流
        FileInputStream inputStream = new FileInputStream(new File("dbcp.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("dcp1.txt"));

        //转换流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");

        //
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        //读取每一行数据
        String data = null;
        while ((data = bufferedReader.readLine()) != null) {
            bufferedWriter.write(data);
            bufferedWriter.newLine();
        }

        //关闭
        bufferedReader.close();
        bufferedWriter.close();
    }
}
