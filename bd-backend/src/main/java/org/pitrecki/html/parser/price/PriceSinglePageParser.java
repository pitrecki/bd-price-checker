package org.pitrecki.html.parser.price;

import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;
import org.pitrecki.html.parser.SinglePageParser;

import java.math.BigDecimal;

import static org.pitrecki.html.utils.PriceExtractorUtils.extractPrice;

@AllArgsConstructor
public class PriceSinglePageParser implements SinglePageParser<BigDecimal> {

    private final Document document;

    @Override
    public BigDecimal extract(String path) {
        String price = document.select(path).first().text();
        return new BigDecimal(extractPrice(price));
    }
}
