package org.pitrecki.html.extractor.grid;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitleGridViewExtractor extends AbstractGridViewExtractor<String> {

    public TitleGridViewExtractor(@Value("${grid.view.author}") String priceXpath) {
        super(priceXpath);
    }

    @Override
    boolean filter(Object o) {
        return o instanceof Element;
    }

    @Override
    String extractContent(Node node) {
        Element element = (Element) node;
        return element.text();
    }
}
