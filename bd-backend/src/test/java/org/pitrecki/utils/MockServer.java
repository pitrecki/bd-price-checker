package org.pitrecki.utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.NoArgsConstructor;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.OK;

@NoArgsConstructor(access = PRIVATE)
public class MockServer {

    private static final int DEFAULT_PORT = 1234;
    private static final WireMockServer server = new WireMockServer(DEFAULT_PORT);

    public static void start() {
        server.start();
    }

    public static void stop() {
        server.shutdown();
    }

    public static void mockRequest(String url, String responseBody) {
        server.stubFor(any(urlEqualTo(url))
                .willReturn(aResponse()
                        .withBody(responseBody)
                        .withStatus(OK.value())));
    }

}
