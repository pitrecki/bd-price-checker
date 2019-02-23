package org.pitrecki.html.extractor.grid;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.pitrecki.html.extractor.ElementExtractor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
abstract class AbstractGridViewExtractor<E> implements ElementExtractor<List<E>> {

    private final String xpath;

    @Override
    public List<E> extract(Document document) {
        return document.select(xpath).stream()
                .flatMap(element -> element.childNodes().stream())
                .filter(node -> filter(node) && filterEmptyNode(node))
                .map(this::extractContent)
                .collect(toList());
    }

    private boolean filterEmptyNode(Node node) {
        return !node.toString().equals(" ");
    }

    abstract E extractContent(Node node);

    abstract boolean filter(Object o);

}
