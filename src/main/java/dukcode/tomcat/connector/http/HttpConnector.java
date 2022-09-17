package dukcode.tomcat.connector.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable {

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try (ServerSocket serverSocket = new ServerSocket(Constants.BASIC_PORT,
                1, InetAddress.getByName("127.0.0.1"));) {
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    HttpProcessor processor = new HttpProcessor(this);
                    processor.process(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

}
