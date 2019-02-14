package org.pitrecki.model

import spock.lang.Specification

import static org.pitrecki.model.Currency.GBP

class CurrencySpec extends Specification {

    private static final String GBP_SYMBOL = "£"

    def "should initialize currency and return expected value"() {
        when:
        def currency = GBP

        then:
        currency.getValue() == GBP_SYMBOL
    }
}
