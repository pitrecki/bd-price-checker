package org.pitrecki.html.extractor.factory.grid

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer

import static org.pitrecki.utils.MockServer.mockRequest
import static org.pitrecki.utils.TestUtils.loadFile

class GridViewElementExtractorSpec extends TestServer {
    private static final String FILE = "classpath:pages/grid_view.html"
    private static final String XPATH = "div.book-item > div.item-info > h3.title > a, p.author > a, div.price-wrap > p.price"

    private GridViewElementExtractor extractor = new GridViewElementExtractor(XPATH)

    void setup() {
        mockRequest(REQUEST_PATH, loadFile(FILE))
    }

    def "should create list with positions from given document"() {
        given:
        def document = new Connector().connect(FULL_PATH).parse()

        when:
        def actual = extractor.extractElementsFromGridView(document)

        then:
        actual == [" Grand Blue Dreaming 1",
                   "Kimitake Yoshioka",
                   " 45,34 zł &nbsp;",
                   " Grand Blue Dreaming 2",
                   "Satoshi Monoko",
                   " 45,79 zł &nbsp;",
                   " Grand Blue Dreaming 3",
                   "Akira Kurosawa",
                   " 45,34 zł &nbsp;"]

    }

}
