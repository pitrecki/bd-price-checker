package org.pitrecki.html.extractor.analyzer

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer
import org.pitrecki.html.extractor.ElementExtractor
import spock.lang.Unroll

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class PageAnalyzerSpec extends TestServer {

    private static final String GRID_VIEW_FILE = "classpath:pages/grid_view.html"
    private static final String SINGLE_VIEW_FILE = "classpath:pages/single_view.html"
    private static final List<String> XPATHS = ["div.content-block", "li#next-bottom.next", "li#next-top.next"]

    private ElementExtractor<Boolean> extractor = new PageAnalyzer(XPATHS)

    @Unroll("should return #actual if given document is grid view")
    def "should return boolean value if given document is grid view"() {
        given:
        mockRequest(REQUEST_PATH, loadFile(file))
        def document = new Connector().connect(FULL_PATH).parse()

        expect:
        actual == extractor.extract(document)

        where:
        file             | actual
        GRID_VIEW_FILE   | true
        SINGLE_VIEW_FILE | false
    }
}
