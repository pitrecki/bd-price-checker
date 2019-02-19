package org.pitrecki.html.extractor.price

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class PriceGridViewParserSpec extends TestServer {

    private static final String FILE = "classpath:pages/grid_view.html"
    private static final String XPATH = "p.price"

    def "should read html file and extract price by given xpath"() {
        given:
        def content = loadFile(FILE)
        mockRequest(REQUEST_PATH, content)
        def doc = new Connector().connect(FULL_PATH).parse()
        def parser = new PriceGridViewExtractor(doc)
        when:
        def prices = parser.extract(XPATH)

        def d = [1]

        then:
        prices.size() > 0
        prices == [45.34, 45.79, 45.34, 46.83, 44.95, 44.95, 44.95, 44.95]
    }

}
