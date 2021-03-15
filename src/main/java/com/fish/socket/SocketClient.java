package com.fish.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author jiangbing
 * @date 2021/3/15 19:21
 * notes and tips:
 */
public class SocketClient {

    public static void main(String[] args) {
        Socket socket;
        {
            try {
                socket = new Socket("127.0.0.1", 8899);

                while (true) {

                    InputStream inputStream = socket.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader reader = new BufferedReader(inputStreamReader);

                    OutputStream outputStream = socket.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    BufferedWriter writer = new BufferedWriter(outputStreamWriter);

                    String inputMessage = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    writer.write(inputMessage + System.lineSeparator());
                    writer.flush();
                    System.out.println("[server]:" + reader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
