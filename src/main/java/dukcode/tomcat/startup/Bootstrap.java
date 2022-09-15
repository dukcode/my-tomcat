package dukcode.tomcat.startup;

import dukcode.tomcat.connector.http.HttpConnector;

public class Bootstrap {

    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }

}
