package org.pitrecki.html;

import org.apache.logging.log4j.Logger;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.Proxy;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Connector {

    private static final Logger logger = getLogger();

    public Response connect(String url) {
        return connect(url, null);
    }

    public Response connect(String url, Proxy proxy) {
        Response resp = null;
        try {
            resp = Jsoup.connect(url).proxy(proxy).execute();

        } catch (IOException e) {
            logger.error("Unable to connect site: {}", url);
        }
        return resp;
    }

}
