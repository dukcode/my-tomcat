package dukcode.tomcat.http.constant;

import java.io.File;

public class Constants {

    public static final int BASIC_PORT = 8080;
    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator + "webroot";
}
