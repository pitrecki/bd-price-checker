package org.pitrecki.html.extractor.grid

import org.pitrecki.html.extractor.AbstractExtractorSpec
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class PriceGridViewExtractorSpec extends AbstractExtractorSpec {

    private static final String FILE = "classpath:pages/grid_view.html"
    private static final String XPATH = "p.price"

    private ElementExtractor<List<BigDecimal>> extractor = new PriceGridViewExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should create list of prices from given document"() {
        expect:
        assertExtractedResults(extractor, [45.34, 45.79, 45.34])
    }
}
