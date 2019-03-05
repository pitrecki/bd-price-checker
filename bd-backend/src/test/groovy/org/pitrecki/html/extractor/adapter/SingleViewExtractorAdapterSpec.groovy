package org.pitrecki.html.extractor.adapter

import org.jsoup.nodes.Document
import org.pitrecki.html.extractor.ElementExtractor
import org.pitrecki.html.extractor.single.AuthorSinglePageExtractor
import org.pitrecki.html.extractor.single.CurrencySinglePageExtractor
import org.pitrecki.html.extractor.single.PriceSinglePageExtractor
import org.pitrecki.html.extractor.single.TitleSinglePageExtractor
import org.pitrecki.model.Currency
import spock.lang.Specification

import static org.pitrecki.model.Currency.PLN
import static org.pitrecki.utils.TestUtils.loadEmtpyDocument

class SingleViewExtractorAdapterSpec extends Specification {

    private static final Currency SOME_CURRENCY = PLN
    private static final String SOME__TITLE = "SOME_TITLE"
    private static final String SOME__AUTHOR = "SOME_AUTHOR"
    private static final BigDecimal SOME_PRICE = new BigDecimal(66.66)
    private static final Document DOCUMENT = loadEmtpyDocument()

    private ElementExtractor authorExtractor = Mock(AuthorSinglePageExtractor.class)
    private ElementExtractor currencyExtractor = Mock(CurrencySinglePageExtractor.class)
    private ElementExtractor priceExtractor = Mock(PriceSinglePageExtractor.class)
    private ElementExtractor titleExtractor = Mock(TitleSinglePageExtractor.class)

    private SingleViewExtractorAdapter adapter =
            new SingleViewExtractorAdapter(authorExtractor, currencyExtractor, priceExtractor, titleExtractor)

    def "should create position from given document"() {
        when:
        def actual = adapter.createPosition(DOCUMENT)

        then:
        verifyAll(actual) {
            actual.currency == SOME_CURRENCY
            actual.author == SOME__AUTHOR
            actual.title == SOME__TITLE
            actual.price == SOME_PRICE
        }

        and:
        1 * currencyExtractor.extract(DOCUMENT) >> SOME_CURRENCY
        1 * authorExtractor.extract(DOCUMENT) >> SOME__AUTHOR
        1 * priceExtractor.extract(DOCUMENT) >> SOME_PRICE
        1 * titleExtractor.extract(DOCUMENT) >> SOME__TITLE
    }
}
