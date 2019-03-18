package org.pitrecki.html.extractor.single


import org.pitrecki.html.extractor.AbstractExtractorSpec
import org.pitrecki.html.extractor.ElementExtractor
import org.pitrecki.model.Currency

import static org.pitrecki.model.Currency.PLN
import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class CurrencySinglePageExtractorSpec extends AbstractExtractorSpec {

    private static final String FILE = "classpath:pages/single_view.html"
    private static final String XPATH = "span.sale-price"
    private static final Currency EXPECTED_VALUE = PLN

    private ElementExtractor<String> extractor = new CurrencySinglePageExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should extract currency by given xpath"() {
        expect:
        assertExtractedResult(extractor, EXPECTED_VALUE)
    }

}
