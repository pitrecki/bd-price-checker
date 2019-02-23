package org.pitrecki.html.extractor.single

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class TitleSinglePageExtractorSpec extends TestServer {

    private static final String FILE = "classpath:pages/single_view.html"
    private static final String XPATH = "h1[itemprop='name']"
    private static final String EXPECTED_VALUE = "Grand Blue Dreaming 1"

    private ElementExtractor<String> extractor = new TitleSinglePageExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should extract title by given xpath"() {
        given:
        def document = new Connector().connect(FULL_PATH).parse()

        when:
        def actual = extractor.extract(document)

        then:
        actual == EXPECTED_VALUE
    }

}
