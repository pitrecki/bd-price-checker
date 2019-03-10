package org.pitrecki.html.extractor.analyzer;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.pitrecki.html.extractor.ElementExtractor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageTypeValidator {

    @Qualifier("pageAnalyzer") private final ElementExtractor<Boolean> viewElementsSearcher;

    public boolean isGivenDocumentContainsGridViewElements(Document document) {
        return viewElementsSearcher.extract(document);
    }

}
