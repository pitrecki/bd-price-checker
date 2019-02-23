package org.pitrecki.html.extractor;

import org.jsoup.nodes.Document;

public interface ElementExtractor<E> {
    E extract(Document document);
}
