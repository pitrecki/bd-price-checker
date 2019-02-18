package org.pitrecki.html


import static java.net.InetSocketAddress.createUnresolved
import static java.net.Proxy.Type.HTTP
import static org.pitrecki.utils.MockServer.mockRequest

class ConnectorSpec extends TestServer {

    private static final String SOME_RESPONSE = "<html/>"
    private static final int HTTP_OK = 200

    private Connector connector = new Connector()

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

}
