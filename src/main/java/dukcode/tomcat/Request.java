package dukcode.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class Request {

    private static final int BUFFER_SIZE = 2048;

    private final InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parse() {
        byte[] buffer = new byte[BUFFER_SIZE];

        try {
            int count = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String requestString = new String(buffer);
        System.out.print(requestString);
        uri = parseUri(requestString);
    }

    private String parseUri(String requestString) {
        StringTokenizer st = new StringTokenizer(requestString);
        String method = st.nextToken();
        String uri = st.nextToken();

        return uri;
    }

    public String getUri() {
        return uri;
    }
}
