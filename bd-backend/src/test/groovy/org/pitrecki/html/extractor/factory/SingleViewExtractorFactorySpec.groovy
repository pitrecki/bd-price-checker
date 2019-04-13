package org.pitrecki.html.extractor.factory


import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.model.Currency

import static org.pitrecki.model.Currency.PLN
import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class SingleViewExtractorFactorySpec extends TestServer {

    private static final String FILE = "classpath:pages/single_view.html"

    private static final String AUTHOR_XPATH = "span[itemprop='name']"
    private static final String PRICE_XPATH = "span.sale-price"
    private static final String TITLE_XPATH = "h1[itemprop='name']"

    private static final String EXPECTED_AUTHOR = "Kimitake Yoshioka"
    private static final Currency EXPECTED_CURRENCY = PLN
    private static final BigDecimal EXPECTED_PRICE = new BigDecimal("45.34")
    private static final String EXPECTED_TITLE = "Grand Blue Deaming 1"

    private SingleViewExtractorFactory adapter =
            new SingleViewExtractorFactory(AUTHOR_XPATH, TITLE_XPATH, PRICE_XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should create position from given document"() {
        given:
        def document = new Connector().connect(FULL_PATH).parse()

        when:
        def actual = adapter.createPosition(document)

        then:
        verifyAll(actual) {
            actual.currency == EXPECTED_CURRENCY
            actual.author == EXPECTED_AUTHOR
            actual.title == EXPECTED_TITLE
            actual.price == EXPECTED_PRICE
        }
    }
}
