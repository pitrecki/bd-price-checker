package org.pitrecki.html.extractor.grid


import org.pitrecki.html.extractor.AbstractExtractorSpec
import org.pitrecki.html.extractor.ElementExtractor
import org.pitrecki.model.Currency

import static org.pitrecki.model.Currency.PLN
import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class CurrencyGridViewExtractorSpec extends AbstractExtractorSpec {

    private static final String XPATH = "p.price"
    private static final String FILE = "classpath:pages/grid_view.html"

    private ElementExtractor<List<Currency>> extractor = new CurrencyGridViewExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should exctract list of currency by given xpath"() {
        expect:
        assertExtractedResults(extractor, [PLN, PLN, PLN])
    }

}
