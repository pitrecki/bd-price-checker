package org.pitrecki.html.extractor.grid;

import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.pitrecki.model.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.pitrecki.html.utils.ExtractorUtils.convertCurrency;

@Component
public class CurrencyGridViewExtractor extends AbstractGridViewExtractor<Currency> {

    public CurrencyGridViewExtractor(@Value("${grid.view.currency}") String currencyXpath) {
        super(currencyXpath);
    }

    @Override
    Currency extractContent(Node node) {
        TextNode textNode = (TextNode) node;
        return convertCurrency(textNode.getWholeText());
    }

    @Override
    boolean filter(Object o) {
        return o instanceof TextNode;
    }
}
