package dukcode.tomcat;

import dukcode.tomcat.connector.http.Constants;
import dukcode.tomcat.connector.http.HttpRequest;
import dukcode.tomcat.connector.http.HttpRequestFacade;
import dukcode.tomcat.connector.http.HttpResponse;
import dukcode.tomcat.connector.http.HttpResponseFacade;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import javax.servlet.Servlet;

public class ServletProcessor {

    public void process(HttpRequest req, HttpResponse res) {
        String uri = req.getRequestURI();
        String servletName = uri.substring(uri.lastIndexOf('/') + 1);

        URLClassLoader loader = null;

        try {
            URL[] urls = new URL[1];
            File classPath = new File(Constants.WEB_ROOT);

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
        HttpRequestFacade reqFacade = new HttpRequestFacade(req);
        HttpResponseFacade resFacade = new HttpResponseFacade(res);

        try {
            servlet = (Servlet) myClass.getConstructor().newInstance();
            servlet.service(reqFacade, resFacade);
            res.finishResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
