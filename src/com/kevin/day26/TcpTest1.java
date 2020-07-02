package com.kevin.day26;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-24-21:01
 */
public class TcpTest1 {



    //传输文件

    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream inputStream = null;
        InputStream inputStream1 = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {

            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //首先建立套接字对象
            socket = new Socket(inetAddress, 8899);
            //
            outputStream = socket.getOutputStream();
            Path path = Paths.get("01.jpg");
            inputStream = new FileInputStream(path.toFile());

            int len = 0;
            byte[] buffer = new byte[10];
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }


            inputStream1 = socket.getInputStream();
            int length = 0;
            byte[] bytes = new byte[10];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while ((length = inputStream1.read(buffer)) != -1) {
                byteArrayOutputStream.write(bytes,0,length);
            }
            System.out.println(byteArrayOutputStream.toString());
//            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }


    @Test
    public void Server() {


        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            serverSocket = new ServerSocket(8899);

            accept = serverSocket.accept();

            inputStream = accept.getInputStream();

            fileOutputStream = new FileOutputStream(new File("05.jpg"));

            int len = 0;
            byte[] buffer = new byte[10];

            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }

            System.out.println("成功收到图片！");
            //返回收到的信息
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("收到你发来的图片".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
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

            if (accept != null) {
                try {
                    accept.close();
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
