package dukcode.tomcat;

import dukcode.tomcat.connector.http.HttpRequest;
import dukcode.tomcat.connector.http.HttpResponse;
import java.io.IOException;

public class StaticResourceProcessor {

    public void process(HttpRequest req, HttpResponse res) {
        try {
            res.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
