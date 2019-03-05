package org.pitrecki.html.extractor.adapter;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.pitrecki.html.extractor.ElementExtractor;
import org.pitrecki.model.Currency;
import org.pitrecki.model.Position;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class SingleViewExtractorAdapter {

    @Qualifier("authorSinglePageExtractor") private final ElementExtractor<String> authorExtractor;
    @Qualifier("currencySinglePageExtractor") private final ElementExtractor<Currency> currenctExtractor;
    @Qualifier("priceSinglePageExtractor") private final ElementExtractor<BigDecimal> priceExtractor;
    @Qualifier("titleSinglePageExtractor") private final ElementExtractor<String> titleExtractor;


    public Position createPosition(Document document) {
        Currency currency = currenctExtractor.extract(document);
        String author = authorExtractor.extract(document);
        BigDecimal price = priceExtractor.extract(document);
        String title = titleExtractor.extract(document);
        return new Position(title, author, price, currency);
    }
}
