package dukcode.tomcat;

import dukcode.tomcat.request.Request;
import dukcode.tomcat.response.Response;

public class StaticResourceProcessor {

    public void process(Request req, Response res) {
        res.sendStaticResource();
    }

}
