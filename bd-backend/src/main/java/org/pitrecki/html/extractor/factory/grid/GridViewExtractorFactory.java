package org.pitrecki.html.extractor.factory.grid;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.pitrecki.model.Currency;
import org.pitrecki.model.Position;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.pitrecki.html.utils.ExtractorUtils.convertCurrency;
import static org.pitrecki.html.utils.ExtractorUtils.convertPrice;

@Component
@RequiredArgsConstructor
public class GridViewExtractorFactory {

    private final GridViewElementExtractor extractor;

    public List<Position> createPositions(Document document) {
        List<String> extract = extractor.extractElementsFromGridView(document);

        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < extract.size(); i+= 3) {
            String title = extract.get(i);
            String author = extract.get(i + 1);
            BigDecimal price = convertPrice(extract.get(i + 2));
            Currency currency = convertCurrency(extract.get(i + 2));
            positions.add(Position.aPosition()
                    .title(title)
                    .author(author)
                    .price(price)
                    .currency(currency)
                    .build());
        }
        return positions;
    }

}
