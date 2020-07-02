package com.kevin.day26.project;

/**
 * @author kevin
 * @project Java30天核心技术
 * @create 2020-06-25-10:32
 */


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端的线程
 * @author
 *
 */
public class ClientThreadT extends Thread{
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ClientThreadT(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true){
                System.out.println();
                bw.write(sc.nextLine().trim());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

