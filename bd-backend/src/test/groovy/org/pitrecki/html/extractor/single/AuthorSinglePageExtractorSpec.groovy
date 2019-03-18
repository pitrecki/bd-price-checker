package org.pitrecki.html.extractor.single


import org.pitrecki.html.extractor.AbstractExtractorSpec
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class AuthorSinglePageExtractorSpec extends AbstractExtractorSpec {

    private static final String FILE = "classpath:pages/single_view.html"
    private static final String XPATH = "span[itemprop='name']"
    private static final String EXPECTED_VALUE = "Kimitake Yoshioka"

    private ElementExtractor<String> extractor = new AuthorSinglePageExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should extract author by given xpath"() {
        expect:
        assertExtractedResult(extractor, EXPECTED_VALUE)
    }
}
