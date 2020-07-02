package com.kevin.day25;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-21-21:45
 */



public class WordCount {
    public static void main(String[] args)  {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {


            File file = new File("dbcp.txt");
            File file1 = new File("word.txt");

            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            int len = 0;
            char ch = 0;
            //
            while ((len = bufferedReader.read()) != -1) {
                ch = (char)len;

                if (hashMap.get(ch)==null) {
                    hashMap.put(ch, 1);
                }else{
                    hashMap.put(ch,hashMap.get(ch)+1);
                }
            }


            Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                switch (entry.getKey()) {
                    case ' ':
                        bufferedWriter.write("空格："+entry.getValue());
                        break;
                    case '\t':
                        bufferedWriter.write("tab健：" + entry.getValue());
                        break;
                    case '\n':
                        bufferedWriter.write("回车：" + entry.getValue());
                        break;
                    default:
                        bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
                        break;
                }
                bufferedWriter.newLine();

                //关闭

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
