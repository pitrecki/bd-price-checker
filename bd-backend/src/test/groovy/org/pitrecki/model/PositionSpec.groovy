package org.pitrecki.model

import spock.lang.Specification

import static org.pitrecki.model.Currency.PLN

class PositionSpec extends Specification {

    private static final String SOME_AUTHOR = "someAuthor"
    private static final String SOME_TITTLE = "someTittle"
    private static final Currency CURRENCY = PLN
    private static final BigDecimal PRICE = new BigDecimal(12.21)


    def "should generate position and return expected fields values"() {
        when:
        def position = new Position(SOME_TITTLE, SOME_AUTHOR, PRICE, CURRENCY)

        then:
        verifyAll(position) {
            author == SOME_AUTHOR
            title == SOME_TITTLE
            price == PRICE
            currency == CURRENCY
        }
    }
}
