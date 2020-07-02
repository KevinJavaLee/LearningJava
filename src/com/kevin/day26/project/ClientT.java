package com.kevin.day26.project;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-10:32
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 客户端
 * @author
 *
 */
public class ClientT {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            ClientThreadT t  = new ClientThreadT(socket);
            t.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String strIn = "";
            while(true){
                strIn = br.readLine();
                System.out.println(strIn);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
