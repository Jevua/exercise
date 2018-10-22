package com.example.exercise.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        Socket client = new Socket(host,8888);
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("hello");
        writer.flush();
        writer.close();
        client.close();
    }
}
