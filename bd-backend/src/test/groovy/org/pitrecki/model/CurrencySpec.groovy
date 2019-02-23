package org.pitrecki.model

import spock.lang.Specification

import static org.pitrecki.model.Currency.GBP
import static org.pitrecki.model.Currency.fromString

class CurrencySpec extends Specification {

    private static final String GBP_SYMBOL = "£"
    public static final String MALFORMED_SYMBOL = "MALF"

    def "should initialize currency and return expected value"() {
        when:
        def currency = GBP

        then:
        currency.getValue() == GBP_SYMBOL
    }

    def "should extract currency from given string"() {
        when:
        def actual = fromString(GBP_SYMBOL)

        then:
        actual == GBP
    }

    def "should extract null when string not match currency"() {
        when:
        def actual = fromString(MALFORMED_SYMBOL)

        then:
        actual == null
    }
}
