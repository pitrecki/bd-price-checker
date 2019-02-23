package org.pitrecki.html.extractor.grid

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.html.extractor.ElementExtractor

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class AuthorGridViewExtractorSpec extends TestServer {

    private static final String FILE = "classpath:pages/grid_view.html"
    private static final String XPATH = "p.author"

    private ElementExtractor<List<String>> extractor = new AuthorGridViewExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should create list of authors from given document"() {
        given:
        def document = new Connector().connect(FULL_PATH).parse()

        when:
        def actual = extractor.extract(document)

        then:
        actual.containsAll(expected)

        where:
        expected << ["Kimitake Yoshioka", "Satoshi Monoko", "Akira Kurosawa"]
    }
}
