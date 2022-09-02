package dukcode.tomcat;

import dukcode.tomcat.request.Request;
import dukcode.tomcat.response.Response;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor {

    public void process(Request req, Response res) {
        String uri = req.getUri();
        String servletName = uri.substring(uri.lastIndexOf('/') + 1);

        URLClassLoader loader = null;

        try {
            URL[] urls = new URL[1];
            File classPath = new File(HttpServer.WEB_ROOT);

            String repository = (new URL("file", null,
                    classPath.getCanonicalPath() + File.separator)).toString();

            URLStreamHandler streamHandler = null;
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Servlet servlet = null;

        try {
            servlet = (Servlet) myClass.getConstructor().newInstance();
            servlet.service((ServletRequest) req, (ServletResponse) res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
