package com.kevin.day26.project;

import java.net.Socket;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-10:30
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 服务端线程
 * @author
 *
 */
public class ServiceThreadT extends Thread{
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ServiceThreadT(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            @SuppressWarnings("resource")
            BufferedWriter wFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://messagesT.txt",true)));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String strOut = "";
            String strIn = "";
            while(true){
                strIn = socket.getInetAddress().getHostAddress()+":"+br.readLine();
                strOut = strIn;
                wFile.write(strIn);
                System.out.println(strOut);
                wFile.newLine();
                wFile.flush();
//                for (Socket soc : ServiceT.list) {
//                    if(soc != socket){
//                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
//                        bw.write(strOut);
//                        System.out.println(strOut);
//                        bw.newLine();
//                        bw.flush();
//                    }
//                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
