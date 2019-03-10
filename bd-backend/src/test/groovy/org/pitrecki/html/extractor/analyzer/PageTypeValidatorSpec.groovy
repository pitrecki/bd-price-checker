package org.pitrecki.html.extractor.analyzer

import org.pitrecki.html.extractor.ElementExtractor
import spock.lang.Specification

import static org.pitrecki.utils.TestUtils.loadEmtpyDocument

class PageTypeValidatorSpec extends Specification {

    private ElementExtractor<Boolean> extractor = Mock(PageAnalyzer.class)

    private PageTypeValidator validator = new PageTypeValidator(extractor)

    def "should true for given document"() {
        when:
        def actual = validator.isGivenDocumentContainsGridViewElements(loadEmtpyDocument())

        then:
        actual

        and:
        1 * extractor.extract(_) >> true
    }
}
