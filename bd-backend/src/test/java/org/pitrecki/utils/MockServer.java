package org.pitrecki.utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import lombok.NoArgsConstructor;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static java.lang.Thread.sleep;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.OK;

@NoArgsConstructor(access = PRIVATE)
public class MockServer {

    private static final int DEFAULT_PORT = 1234;
    private static final WireMockConfiguration CONFIGURATION = options()
            .notifier(null)
            .port(DEFAULT_PORT);

    private static final WireMockServer server = new WireMockServer(CONFIGURATION);

    public static void start() {
        server.start();
    }

    public static void stop() {
            server.shutdown();
    }

    public static void flush() throws InterruptedException {
        server.resetAll();
        sleep(101);
    }

    public static void mockRequest(String url, String responseBody) {
        server.stubFor(any(urlEqualTo(url))
                .willReturn(aResponse()
                        .withBody(responseBody)
                        .withStatus(OK.value())));
    }

}
