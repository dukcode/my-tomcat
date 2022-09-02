package dukcode.tomcat;

public class StaticResourceProcessor {

    public void process(Request req, Response res) {
        res.sendStaticResource();
    }

}
