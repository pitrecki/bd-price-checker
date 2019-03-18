package org.pitrecki.html.extractor.adapter

import org.jsoup.nodes.Document
import org.pitrecki.html.extractor.ElementExtractor
import org.pitrecki.html.extractor.grid.AuthorGridViewExtractor
import org.pitrecki.html.extractor.grid.CurrencyGridViewExtractor
import org.pitrecki.html.extractor.grid.PriceGridViewExtractor
import org.pitrecki.html.extractor.grid.TitleGridViewExtractor
import org.pitrecki.model.Currency
import org.pitrecki.model.Position
import spock.lang.Specification

import static org.pitrecki.model.Currency.PLN
import static org.pitrecki.utils.TestUtils.loadEmtpyDocument

class GridViewExtractorAdapterSpec extends Specification {

    private static final BigDecimal PRICE = new BigDecimal(66.66)
    private static final String AUTHOR = "SOME_AUTHOR"
    private static final String TITLE = "SOME_TITLE"
    private static final Currency CURRENCY = PLN
    private static final Position POSITION = new Position(TITLE, AUTHOR, PRICE, CURRENCY)
    private static final Document DOCUMENT = loadEmtpyDocument()

    private ElementExtractor authorExtractor = Mock(AuthorGridViewExtractor.class)
    private ElementExtractor currencyExtractor = Mock(CurrencyGridViewExtractor.class)
    private ElementExtractor priceExtractor = Mock(PriceGridViewExtractor.class)
    private ElementExtractor titleExtractor = Mock(TitleGridViewExtractor.class)

    private GridViewExtractorAdapter adapter =
            new GridViewExtractorAdapter(authorExtractor, currencyExtractor, priceExtractor, titleExtractor)

    def "should create list of positions from given document"() {
        when:
        def actual = adapter.createPositions(DOCUMENT)

        then:
        actual.each { assert it == POSITION }

        and:
        1 * currencyExtractor.extract(DOCUMENT) >> [CURRENCY, CURRENCY]
        1 * authorExtractor.extract(DOCUMENT) >> [AUTHOR, AUTHOR]
        1 * priceExtractor.extract(DOCUMENT) >> [PRICE, PRICE]
        1 * titleExtractor.extract(DOCUMENT) >> [TITLE, TITLE]
    }

    def "should return empty list when extracted size positions not match"() {
        when:
        def actual = adapter.createPositions(DOCUMENT)

        then:
        actual.isEmpty()

        and:
        1 * currencyExtractor.extract(DOCUMENT) >> [CURRENCY]
        1 * authorExtractor.extract(DOCUMENT) >> [AUTHOR]
        1 * priceExtractor.extract(DOCUMENT) >> [PRICE]
        1 * titleExtractor.extract(DOCUMENT) >> [TITLE, TITLE]

    }
}
