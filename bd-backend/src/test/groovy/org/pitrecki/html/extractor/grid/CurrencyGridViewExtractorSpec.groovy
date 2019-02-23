package org.pitrecki.html.extractor.grid

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.html.extractor.ElementExtractor
import org.pitrecki.model.Currency

import static org.pitrecki.model.Currency.PLN
import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class CurrencyGridViewExtractorSpec extends TestServer {

    private static final String XPATH = "p.price"
    private static final String FILE = "classpath:pages/grid_view.html"

    private ElementExtractor<List<Currency>> extractor = new CurrencyGridViewExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should exctract list of currency by given xpath"() {
        given:
        def document = new Connector().connect(FULL_PATH).parse()

        when:
        def actual = extractor.extract(document)

        then:
        actual.containsAll(expected)

        where:
        expected << [PLN, PLN, PLN]
    }
}
