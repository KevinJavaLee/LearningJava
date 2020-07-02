package com.kevin.day26;

import org.junit.Test;
import sun.security.util.AuthResources_it;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-24-20:32
 */
public class Iptest {

    @Test
    public void test() throws UnknownHostException {

        InetAddress localhaost = InetAddress.getByName("www.baidu.com");
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localhaost);
        System.out.println(localHost);


    }


    @Test
    public void client() {

        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //指定ip地址
            InetAddress byName = InetAddress.getByName("127.0.0.1");

            //2.创建socket对象创建ip地址和端口号
            socket = new Socket(byName, 7888);
            //获取一个输出流
            outputStream = socket.getOutputStream();

            outputStream.write("匡总牛逼飞机匡牛逼".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭输出流
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //关闭套接字

        }

    }

    @Test
    public void server() {

        //建立服务器套接字
        Socket accept = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        InputStream inputStream = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7888);
            //
            accept = serverSocket.accept();
            //获取输入流
            inputStream = accept.getInputStream();

            int len = 0;
            byteArrayOutputStream = new ByteArrayOutputStream();
            //读取数据
            byte[] buffer = new byte[5];

            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer,0,len);
            }

            System.out.println(byteArrayOutputStream.toString() +":" + serverSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }



    }

}
