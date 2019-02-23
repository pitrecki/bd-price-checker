package org.pitrecki.html.extractor.grid

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class TitleGridViewExtractorSpec extends TestServer {

    private static final String FILE = "classpath:pages/grid_view.html"
    private static final String XPATH = "h3.title"

    private ElementExtractor<List<String>> extractor = new TitleGridViewExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should create list of titles from given document"() {
        given:
        def document = new Connector().connect(FULL_PATH).parse()

        when:
        def actual = extractor.extract(document)

        then:
        actual.containsAll(expected)

        where:
        expected << ["Grand Blue Dreaming 1", "Grand Blue Dreaming 2", "Grand Blue Dreaming 3"]

    }
}
