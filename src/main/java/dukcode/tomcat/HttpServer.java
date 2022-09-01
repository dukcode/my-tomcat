package dukcode.tomcat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator + "webroot";

    public static final int DEFAULT_PORT = 8080;

    private static final String SHUTDOWN_COMMAND = "/shutdown";

    private boolean shutdown = false;


    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    private void await() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(DEFAULT_PORT, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutdown) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                output.write("Hello World!!!\n\n".getBytes());

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
