package org.pitrecki.html.extractor.grid;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.pitrecki.html.utils.ExtractorUtils.convertPrice;

@Component
public class PriceGridViewExtractor extends AbstractGridViewExtractor<BigDecimal> {

    public PriceGridViewExtractor(@Value("${grid.view.price}") String priceXpath) {
        super(priceXpath);
    }

    @Override
    BigDecimal extractContent(Node node) {
        TextNode textNode = (TextNode) node;
        return convertPrice(textNode.getWholeText());
    }

    @Override
    boolean filter(Object o) {
        return o instanceof TextNode;
    }
}
