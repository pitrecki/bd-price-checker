package org.pitrecki.html.extractor.factory.grid;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.pitrecki.html.extractor.ElementExtractor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class GridViewElementExtractor {

    private static final String EMPTY_STRING = "";
    private static final String WHITESPACE = " ";

    private final String xpath;

    public GridViewElementExtractor(@Value("${grid.vew.full_path}") String xpath) {
        this.xpath = xpath;
    }

    List<String> extractElementsFromGridView(Document document) {
        ElementExtractor<List<String>> elementExtractor = (doc, s) -> doc.select(s).stream()
                .flatMap(element -> element.childNodes().stream())
                .filter(node -> node instanceof TextNode && isNotEmptyString(node))
                .map(Node::toString)
                .collect(toList());

        return elementExtractor.extract(document, xpath);

    }

    private static boolean isNotEmptyString(Node node) {
        return !node.toString().equals(WHITESPACE) && !node.toString().equals(EMPTY_STRING);
    }
}
