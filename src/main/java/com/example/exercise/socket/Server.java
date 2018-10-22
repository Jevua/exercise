package com.example.exercise.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        Reader reader = new InputStreamReader(socket.getInputStream());
        char chars[] = new char[64];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = reader.read(chars)) != -1) {
            sb.append(new String(chars, 0, len));
        }
        System.out.println("from client:" + sb);
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
