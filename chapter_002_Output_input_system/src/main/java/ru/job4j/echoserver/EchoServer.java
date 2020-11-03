package ru.job4j.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final String OK_CODE = "HTTP/1.1 200 OK\r\n\\";
    private static final String CLOSE_CODE = "GET /?msg=Buy HTTP/1.1";
    private static final int PORT_LOCAL_HOST = 9000;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT_LOCAL_HOST)) {
            outer: while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.contains(CLOSE_CODE)) {
                            break outer;
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write(OK_CODE.getBytes());
                }
            }
        }
    }
}