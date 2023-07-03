package com.dukcode.chap02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response implements ServletResponse {

  private static final int BUFFER_SIZE = 1024;
  Request request;
  OutputStream output;

  public Response(OutputStream output) {
    this.output = output;
  }

  public void setRequest(Request request) {
    this.request = request;
  }

  public void sendStaticResource() throws IOException {
    byte[] bytes = new byte[BUFFER_SIZE];
    FileInputStream fis = null;
    try {
      File file = new File(Constants.WEB_ROOT, request.getUri());
      if (file.exists()) {
        fis = new FileInputStream(file);
        int ch = fis.read(bytes, 0, BUFFER_SIZE);
        while (ch != -1) {
          output.write(bytes, 0, ch);
          ch = fis.read(bytes, 0, BUFFER_SIZE);
        }
      } else {
        String errorMessage = """
            HTTP/1.1 404 File Not Found\r
            Content-Type: text/html\r
            Content-Length: 23\r
            \r
            <h1>File Not Found</h1>""";
        output.write(errorMessage.getBytes());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (fis != null) {
        fis.close();
      }
    }
  }

  @Override
  public PrintWriter getWriter() throws IOException {
    PrintWriter writer = new PrintWriter(output, true);
    return writer;
  }

  /* 이하 SerlvetResponse의 빈 구현 */
  @Override
  public String getCharacterEncoding() {
    return null;
  }

  @Override
  public void setCharacterEncoding(String charset) {

  }

  @Override
  public String getContentType() {
    return null;
  }

  @Override
  public void setContentType(String type) {

  }

  @Override
  public ServletOutputStream getOutputStream() throws IOException {
    return null;
  }

  @Override
  public void setContentLength(int len) {

  }

  @Override
  public int getBufferSize() {
    return 0;
  }

  @Override
  public void setBufferSize(int size) {

  }

  @Override
  public void flushBuffer() throws IOException {

  }

  @Override
  public void resetBuffer() {

  }

  @Override
  public boolean isCommitted() {
    return false;
  }

  @Override
  public void reset() {

  }

  @Override
  public Locale getLocale() {
    return null;
  }

  @Override
  public void setLocale(Locale loc) {

  }
}
