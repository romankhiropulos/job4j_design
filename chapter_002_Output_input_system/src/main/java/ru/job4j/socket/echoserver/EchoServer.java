package ru.job4j.socket.echoserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.logging.UsageLog4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    private static final String OK_CODE = "HTTP/1.1 200 OK\r\n\r\n";
    private static final String CLOSE_CODE = "GET /?msg=Exit";
    private static final String HELLO_CODE = "GET /?msg=Hello";
    private static final int PORT_LOCAL_HOST = 9000;
    private static final String HELLO_MSG = "Hello, dear friend.\n";
    private static final String EXIT_MSG = "Exit.\n";

    public static void main(String[] args) {
        try {
            new EchoServer().runEchoServer();
        } catch (IOException e) {
            LOG.error("IOException", e);
        }
    }

    public void runEchoServer() throws IOException {
        try (ServerSocket server = new ServerSocket(PORT_LOCAL_HOST)) {
            String msgBody = "";
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    while (!str.isEmpty()) {
                        if (str.startsWith("GET")) {
                            msgBody = getMsgBody(str);
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }

                    out.write(OK_CODE.getBytes());
                    out.write(msgBody.concat("\n").getBytes());
                    if (Objects.equals(msgBody, EXIT_MSG)) {
                        break;
                    }
                }
            }
        }
    }

    private String getMsgBody(String str) {
        String result;
        if (str.contains(CLOSE_CODE)) {
            result = EXIT_MSG;
        } else if (str.contains(HELLO_CODE)) {
            result = HELLO_MSG;
        } else {
            result = str.split(" ")[1].substring(6);
        }
        return result;
    }
}