package com.dukcode.chap02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class ResponseFacade implements ServletResponse {

  private Response response;

  public ResponseFacade(Response response) {
    this.response = response;
  }

  /* 이하 위임 메서드 구현 */
  @Override
  public PrintWriter getWriter() throws IOException {
    return response.getWriter();
  }

  @Override
  public String getCharacterEncoding() {
    return response.getCharacterEncoding();
  }

  @Override
  public void setCharacterEncoding(String charset) {
    response.setCharacterEncoding(charset);
  }

  @Override
  public String getContentType() {
    return response.getContentType();
  }

  @Override
  public void setContentType(String type) {
    response.setContentType(type);
  }

  @Override
  public ServletOutputStream getOutputStream() throws IOException {
    return response.getOutputStream();
  }

  @Override
  public void setContentLength(int len) {
    response.setContentLength(len);
  }

  @Override
  public int getBufferSize() {
    return response.getBufferSize();
  }

  @Override
  public void setBufferSize(int size) {
    response.setBufferSize(size);
  }

  @Override
  public void flushBuffer() throws IOException {
    response.flushBuffer();
  }

  @Override
  public void resetBuffer() {
    response.resetBuffer();
  }

  @Override
  public boolean isCommitted() {
    return response.isCommitted();
  }

  @Override
  public void reset() {
    response.reset();
  }

  @Override
  public Locale getLocale() {
    return response.getLocale();
  }

  @Override
  public void setLocale(Locale loc) {
    response.setLocale(loc);
  }
}
