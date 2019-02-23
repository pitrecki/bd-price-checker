package org.pitrecki.html.extractor.single

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class AuthorSinglePageExtractorSpec extends TestServer {

    private static final String FILE = "classpath:pages/single_view.html"
    private static final String XPATH = "span[itemprop='name']"
    private static final String EXPECTED_VALUE = "Kimitake Yoshioka"

    private ElementExtractor<String> extractor = new AuthorSinglePageExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should extract author by given xpath"() {
        given:
        def document = new Connector().connect(FULL_PATH).parse()

        when:
        def actual = extractor.extract(document)

        then:
        actual == EXPECTED_VALUE
    }
}
