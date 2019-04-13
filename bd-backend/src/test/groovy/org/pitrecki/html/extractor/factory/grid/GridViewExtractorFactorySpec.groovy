package org.pitrecki.html.extractor.factory.grid

import org.jsoup.nodes.Document
import spock.lang.Specification

import static org.pitrecki.model.Currency.PLN
import static org.pitrecki.utils.TestUtils.loadEmptyDocument

class GridViewExtractorFactorySpec extends Specification {

    private static final Document DOCUMENT = loadEmptyDocument()
    private static final String AUTHOR = "author"
    private static final String TITLE = "title"

    private GridViewElementExtractor extractor = Mock(GridViewElementExtractor)
    private GridViewExtractorFactory factory = new GridViewExtractorFactory(extractor)

    def "should create position from given list"() {
        when:
        def actual = factory.createPositions(DOCUMENT)

        then:
        actual.each { it ->
            verifyAll(it) {
                it.author == AUTHOR
                it.currency == PLN
                it.price == new BigDecimal(10.00)
                it.title == TITLE
            }
        }

        and:
        1 * extractor.extractElementsFromGridView(DOCUMENT) >> [TITLE, AUTHOR, "10.00 zł"]
    }
}
