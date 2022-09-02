package dukcode.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response implements ServletResponse {

    private static final int BUFFER_SIZE = 2048;

    private final OutputStream output;
    private Request request;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() {
        byte[] buffer = new byte[BUFFER_SIZE];

        File file = new File(HttpServer.WEB_ROOT, request.getUri());
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                int count = 0;
                while ((count = fis.read(buffer, 0, BUFFER_SIZE)) != -1) {
                    output.write(buffer, 0, count);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override public PrintWriter getWriter() throws IOException {
        return new PrintWriter(output, true);
    }

    @Override public String getCharacterEncoding() {
        return null;
    }

    @Override public String getContentType() {
        return null;
    }

    @Override public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override public void setCharacterEncoding(String charset) {

    }

    @Override public void setContentLength(int len) {

    }

    @Override public void setContentType(String type) {

    }

    @Override public void setBufferSize(int size) {

    }

    @Override public int getBufferSize() {
        return 0;
    }

    @Override public void flushBuffer() throws IOException {

    }

    @Override public void resetBuffer() {

    }

    @Override public boolean isCommitted() {
        return false;
    }

    @Override public void reset() {

    }

    @Override public void setLocale(Locale loc) {

    }

    @Override public Locale getLocale() {
        return null;
    }
}
