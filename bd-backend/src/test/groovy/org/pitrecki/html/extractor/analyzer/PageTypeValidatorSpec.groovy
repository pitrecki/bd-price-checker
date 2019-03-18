package org.pitrecki.html.extractor.analyzer

import org.pitrecki.html.extractor.ElementExtractor
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

import static org.pitrecki.utils.TestUtils.loadEmtpyDocument

class PageTypeValidatorSpec extends Specification {

    private ElementExtractor<Boolean> extractor = Mock(PageAnalyzer.class)

    @Subject private PageTypeValidator validator = new PageTypeValidator(extractor)

    @Unroll
    def "should true for given document"() {
        when:
        def actual = validator.isGivenDocumentContainsGridViewElements(loadEmtpyDocument())

        then:
        actual == expected

        and:
        1 * extractor.extract(_) >> expected

        where:
        expected << [true, false]
    }
}
