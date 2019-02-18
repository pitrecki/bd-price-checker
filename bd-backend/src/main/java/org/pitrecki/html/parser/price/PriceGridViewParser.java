package org.pitrecki.html.parser.price;

import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.pitrecki.html.parser.GridViewParser;

import java.math.BigDecimal;
import java.util.Collection;

import static java.util.stream.Collectors.toList;
import static org.pitrecki.html.utils.PriceExtractorUtils.extractPrice;

@AllArgsConstructor
public class PriceGridViewParser implements GridViewParser<BigDecimal> {

    private final Document document;

    @Override
    public Collection<BigDecimal> extract(String path) {
        return document.select(path).stream()
                .map(this::convert)
                .collect(toList());

    }

    private BigDecimal convert(Element element) {
        String text = ((TextNode) element.childNodes().get(0)).getWholeText();
        return new BigDecimal(extractPrice(text));
    }
}
