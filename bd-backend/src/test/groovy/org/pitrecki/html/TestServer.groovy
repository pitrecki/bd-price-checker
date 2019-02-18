package org.pitrecki.html


import spock.lang.Specification

import static java.lang.String.format
import static org.pitrecki.utils.MockServer.start
import static org.pitrecki.utils.MockServer.stop

abstract class TestServer extends Specification {
    public static final String BASE_URL = "localhost"
    public static final int SOME_PORT = 1234
    public static final String REQUEST_PATH = "/some/url"
    public static final String FULL_PATH = format("http://%s:%s%s", BASE_URL, SOME_PORT, REQUEST_PATH)

    void setupSpec() {
        start()
    }

    void cleanupSpec() {
        stop()
    }
}
