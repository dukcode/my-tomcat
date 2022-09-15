package dukcode.tomcat;

import dukcode.tomcat.connector.http.Request;
import dukcode.tomcat.connector.http.Response;

public class StaticResourceProcessor {

    public void process(Request req, Response res) {
        res.sendStaticResource();
    }

}
