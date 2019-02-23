package org.pitrecki.html.extractor.single;

import org.jsoup.nodes.Document;
import org.pitrecki.model.Currency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.lang.String.valueOf;
import static org.pitrecki.html.utils.ExtractorUtils.convertCurrency;

@Component
public class CurrencySinglePageExtractor extends AbstractSingleElementExtractor<Currency> {

    public CurrencySinglePageExtractor(@Value("${single.page.currency}") String currencyXpath) {
        super(currencyXpath);
    }

    @Override
    public Currency extract(Document document) {
        String val = valueOf(super.extract(document));
        return convertCurrency(val);
    }
}
