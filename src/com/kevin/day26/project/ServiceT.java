package com.kevin.day26.project;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-10:30
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 服务端
 * @author
 *
 */
public class ServiceT {
    static ArrayList<Socket> list = new ArrayList<Socket>();
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(9999);
            while(true){
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName()+"连接成功。IP："+socket.getInetAddress().getHostAddress());
                list.add(socket);
                ServiceThreadT t =new ServiceThreadT(socket);
                t.start();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
