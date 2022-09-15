package dukcode.tomcat.connector.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Request implements ServletRequest {

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

    @Override public Object getAttribute(String name) {
        return null;
    }

    @Override public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override public String getCharacterEncoding() {
        return null;
    }

    @Override public void setCharacterEncoding(String env) throws UnsupportedEncodingException {

    }

    @Override public int getContentLength() {
        return 0;
    }

    @Override public String getContentType() {
        return null;
    }

    @Override public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    @Override public String getParameter(String name) {
        return null;
    }

    @Override public Enumeration<String> getParameterNames() {
        return null;
    }

    @Override public String[] getParameterValues(String name) {
        return new String[0];
    }

    @Override public Map<String, String[]> getParameterMap() {
        return null;
    }

    @Override public String getProtocol() {
        return null;
    }

    @Override public String getScheme() {
        return null;
    }

    @Override public String getServerName() {
        return null;
    }

    @Override public int getServerPort() {
        return 0;
    }

    @Override public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override public String getRemoteAddr() {
        return null;
    }

    @Override public String getRemoteHost() {
        return null;
    }

    @Override public void setAttribute(String name, Object o) {

    }

    @Override public void removeAttribute(String name) {

    }

    @Override public Locale getLocale() {
        return null;
    }

    @Override public Enumeration<Locale> getLocales() {
        return null;
    }

    @Override public boolean isSecure() {
        return false;
    }

    @Override public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    @Override public String getRealPath(String path) {
        return null;
    }

    @Override public int getRemotePort() {
        return 0;
    }

    @Override public String getLocalName() {
        return null;
    }

    @Override public String getLocalAddr() {
        return null;
    }

    @Override public int getLocalPort() {
        return 0;
    }

    @Override public ServletContext getServletContext() {
        return null;
    }

    @Override public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse)
            throws IllegalStateException {
        return null;
    }

    @Override public boolean isAsyncStarted() {
        return false;
    }

    @Override public boolean isAsyncSupported() {
        return false;
    }

    @Override public AsyncContext getAsyncContext() {
        return null;
    }

    @Override public DispatcherType getDispatcherType() {
        return null;
    }
}
