package org.pitrecki.html.extractor.single


import org.pitrecki.html.extractor.AbstractExtractorSpec
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class PriceSinglePageExtractorSpec extends AbstractExtractorSpec {

    private static final String FILE = "classpath:pages/single_view.html"
    private static final String XPATH = "span.sale-price"
    private static final BigDecimal EXPECTED_VALUE = new BigDecimal("45.34")

    private ElementExtractor<String> extractor = new PriceSinglePageExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should extract price by given xpath"() {
        expect:
        assertExtractedResult(extractor, EXPECTED_VALUE)
    }
}
