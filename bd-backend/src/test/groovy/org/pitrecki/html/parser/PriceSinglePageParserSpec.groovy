package org.pitrecki.html.parser


import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.html.parser.price.PriceSinglePageParser

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class PriceSinglePageParserSpec extends TestServer {

    private static final String FILE = "classpath:pages/single_view.html"
    private static final String XPATH = "span.sale-price"

    def "should read html file and extract price by given xpath"() {
        given:
        def content = loadFile(FILE)
        mockRequest(REQUEST_PATH, content)
        def doc = new Connector().connect(FULL_PATH).parse()
        def parser = new PriceSinglePageParser(doc)
        when:
        def price = parser.extract(XPATH)

        then:
        price > 0
    }

}
