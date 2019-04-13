package org.pitrecki.html.extractor.factory;

import org.jsoup.nodes.Document;
import org.pitrecki.html.extractor.ElementExtractor;
import org.pitrecki.model.Currency;
import org.pitrecki.model.Position;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.pitrecki.html.utils.ExtractorUtils.convertCurrency;
import static org.pitrecki.html.utils.ExtractorUtils.convertPrice;

@Component
public class SingleViewExtractorFactory {

    private final String authorXpath;
    private final String titleXpath;
    private final String priceXpath;

    public SingleViewExtractorFactory(@Value("${single.page.price}") String authorXpath,
                                      @Value("${single.page.price}") String titleXpath,
                                      @Value("${single.page.price}") String priceXpath) {
        this.authorXpath = authorXpath;
        this.titleXpath = titleXpath;
        this.priceXpath = priceXpath;
    }

    public Position createPosition(Document document) {
        Currency currency = convertCurrency(extractElement(document, priceXpath));
        String author = extractElement(document, authorXpath);
        BigDecimal price = convertPrice(extractElement(document, priceXpath));
        String title = extractElement(document, titleXpath);
        return Position.aPosition()
                .title(title)
                .author(author)
                .price(price)
                .currency(currency)
                .build();
    }

    private static String extractElement(Document document, String xpath) {
        ElementExtractor<String> eElementExtractor = (doc, s) -> doc.select(s).first().text();
        return eElementExtractor.extract(document, xpath);
    }

}
