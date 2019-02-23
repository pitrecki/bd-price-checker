package org.pitrecki.html.extractor.grid;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthorGridViewExtractor extends AbstractGridViewExtractor<String> {

    public AuthorGridViewExtractor(@Value("${grid.view.author}") String authorXpath) {
        super(authorXpath);
    }

    @Override
    String extractContent(Node node) {
        Element element = (Element) node;
        return element.text();
    }

    @Override
    boolean filter(Object o) {
        return o instanceof Element;
    }
}
