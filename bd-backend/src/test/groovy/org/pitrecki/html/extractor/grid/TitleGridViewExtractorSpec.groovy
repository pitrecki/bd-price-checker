package org.pitrecki.html.extractor.grid


import org.pitrecki.html.extractor.AbstractExtractorSpec
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class TitleGridViewExtractorSpec extends AbstractExtractorSpec {

    private static final String FILE = "classpath:pages/grid_view.html"
    private static final String XPATH = "h3.title"

    private ElementExtractor<List<String>> extractor = new TitleGridViewExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should create list of titles from given document"() {
        expect:
        assertExtractedResults(extractor, ["Grand Blue Dreaming 1", "Grand Blue Dreaming 2", "Grand Blue Dreaming 3"])

    }
}
