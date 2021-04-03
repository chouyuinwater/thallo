package com.fish.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jiangbing
 * @date 2021/3/15 19:21
 * notes and tips:
 */
public class SocketServer {


    public static void main(String[] args) {
        ServerSocket serverSocket;
        {
            try {
                serverSocket = new ServerSocket(8899);
                Socket socket = serverSocket.accept();
                System.out.println("connect success: socket: " + socket.getPort() + "|" + socket.getInetAddress() + "|" + socket.getLocalPort() + "|" + socket.getLocalAddress());
                while (true) {

                    InputStream inputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader reader = new BufferedReader(inputStreamReader);

                    OutputStream outputStream = socket.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    BufferedWriter writer = new BufferedWriter(outputStreamWriter);

                    String message = reader.readLine();
                    if (message != null) {
                        System.out.println("[client]:" + message);
                        writer.write(message + System.lineSeparator());
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
