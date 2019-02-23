package org.pitrecki.html.extractor.single;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.pitrecki.html.extractor.ElementExtractor;

@RequiredArgsConstructor
abstract class AbstractSingleElementExtractor<E> implements ElementExtractor {

    private final String xpath;

    @Override
    @SuppressWarnings("unchecked")
    public E extract(Document document) {
        return (E) document.select(xpath).first().text();
    }

}
