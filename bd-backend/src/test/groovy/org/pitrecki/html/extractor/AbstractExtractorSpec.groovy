package org.pitrecki.html.extractor

import org.pitrecki.html.Connector
import org.pitrecki.html.TestServer

class AbstractExtractorSpec extends TestServer {

    void assertExtractedResults(ElementExtractor<List<?>> extractor, List<?> results) {
        Collection actual = init(extractor)

        assert actual.containsAll(results)
    }

    void assertExtractedResult(ElementExtractor<?> extractor, Object result) {
        Object actual = init(extractor)

        assert actual == result
    }

    private Object init(ElementExtractor<?> extractor) {
        def document = new Connector().connect(FULL_PATH).parse()

        extractor.extract(document)
    }
}