package dukcode.tomcat.connector.http;

import dukcode.tomcat.ServletProcessor;
import dukcode.tomcat.StaticResourceProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpProcessor {

    private HttpConnector connector;

    public HttpProcessor(HttpConnector connector) {
        this.connector = connector;
    }

    public void process(Socket socket) {
        try (InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream()) {

            Request request = new Request(input);
            request.parse();

            Response response = new Response(output);
            response.setRequest(request);

            if (request.getUri().startsWith("/servlet/")) {
                ServletProcessor processor = new ServletProcessor();
                processor.process(request, response);
            } else {
                StaticResourceProcessor processor = new StaticResourceProcessor();
                processor.process(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
