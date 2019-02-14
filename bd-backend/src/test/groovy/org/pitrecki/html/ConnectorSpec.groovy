package org.pitrecki.html

import spock.lang.Specification

import static java.lang.String.format
import static java.net.InetSocketAddress.createUnresolved
import static java.net.Proxy.Type.HTTP
import static org.pitrecki.MockServer.*

class ConnectorSpec extends Specification {

    private static final String BASE_URL = "localhost"
    private static final int SOME_PORT = 1234
    private static final String REQUEST_PATH = "/some/url"
    private static final int HTTP_OK = 200
    private static final String SOME_RESPONSE = "<html/>"
    private static final String FULL_PATH = format("http://%s:%s%s", BASE_URL, SOME_PORT, REQUEST_PATH)

    private Connector connector = new Connector()

    void setup() {
        start()
    }

    def "should successfully connect to expected site without proxy and return status OK"() {
        when:
        mockRequest(REQUEST_PATH, SOME_RESPONSE)
        def connect = connector.connect(FULL_PATH)

        then:
        connect.statusCode() == HTTP_OK
    }

    def "should successfully connect to expected site with proxy and return status OK"() {
        given:
        def proxy = new Proxy(HTTP, createUnresolved(BASE_URL, SOME_PORT))

        when:
        mockRequest(REQUEST_PATH, SOME_RESPONSE)
        def connect = connector.connect(FULL_PATH, proxy)

        then:
        connect.statusCode() == HTTP_OK
    }

    void cleanup() {
        stop()
    }
}
