package org.pitrecki.html.extractor.grid


import org.pitrecki.html.extractor.AbstractExtractorSpec
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class AuthorGridViewExtractorSpec extends AbstractExtractorSpec {

    private static final String FILE = "classpath:pages/grid_view.html"
    private static final String XPATH = "p.author"

    private ElementExtractor<List<String>> extractor = new AuthorGridViewExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should create list of authors from given document"() {
        expect:
        assertExtractedResults(extractor, ["Kimitake Yoshioka", "Satoshi Monoko", "Akira Kurosawa"])
    }
}
