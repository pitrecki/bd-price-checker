package org.pitrecki.model

import spock.lang.Specification
import spock.lang.Unroll

import static org.pitrecki.model.Currency.GBP
import static org.pitrecki.model.Currency.fromString

class CurrencySpec extends Specification {

    private static final String GBP_SYMBOL = "£"
    public static final String MALFORMED_SYMBOL = "MALF"

    def "should initialize currency and return expected value"() {
        when:
        def currency = GBP

        then:
        currency.value == GBP_SYMBOL
    }

    @Unroll
    def "should extract currency from given string"() {
        expect:
        extracted == fromString(str)

        where:
        str              || extracted
        GBP_SYMBOL       || GBP
        MALFORMED_SYMBOL || null
    }
}
