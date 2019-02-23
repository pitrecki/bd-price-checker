package org.pitrecki.html.extractor.single;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.lang.String.valueOf;
import static org.pitrecki.html.utils.ExtractorUtils.convertPrice;

@Component
public class PriceSinglePageExtractor extends AbstractSingleElementExtractor<BigDecimal> {

    public PriceSinglePageExtractor(@Value("${single.page.price}") String priceXpath) {
        super(priceXpath);
    }

    @Override
    public BigDecimal extract(Document document) {
        String val = valueOf(super.extract(document));
        return convertPrice(val);
    }

}
