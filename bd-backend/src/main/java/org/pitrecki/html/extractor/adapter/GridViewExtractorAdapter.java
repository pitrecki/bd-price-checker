package org.pitrecki.html.extractor.adapter;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.pitrecki.html.extractor.ElementExtractor;
import org.pitrecki.model.Currency;
import org.pitrecki.model.Position;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;

@Component
@RequiredArgsConstructor
public class GridViewExtractorAdapter {

    @Qualifier("authorGridViewExtractor") private final ElementExtractor<List<String>> authorExtractor;
    @Qualifier("currencyGridViewExtractor") private final ElementExtractor<List<Currency>> currencyExtractor;
    @Qualifier("priceGridViewExtractor") private final ElementExtractor<List<BigDecimal>> priceExtractor;
    @Qualifier("titleGridViewExtractor") private final ElementExtractor<List<String>> titleExtractor;

    public List<Position> createPositions(Document document) {
        List<String> authors = authorExtractor.extract(document);
        List<Currency> currencies = currencyExtractor.extract(document);
        List<BigDecimal> prices = priceExtractor.extract(document);
        List<String> titles = titleExtractor.extract(document);

        return validateSize(authors, currencies, prices, titles)
                ? fill(authors, currencies, prices, titles)
                : emptyList();
    }

    private boolean validateSize(List<?> ... lists) {
        int size = Arrays.stream(lists).mapToInt(List::size).sum();
        return size % lists.length == 0;
    }

    private List<Position> fill(List<String> authors, List<Currency> currencies, List<BigDecimal> prices, List<String> titles) {
        List<Position> positions = new ArrayList<>();
        IntStream.range(0, authors.size())
                .forEachOrdered(i -> {
                    String author = authors.get(i);
                    Currency currency = currencies.get(i);
                    BigDecimal price = prices.get(i);
                    String title = titles.get(i);
                    positions.add(new Position(title, author, price, currency));
                });
        return positions;
    }
}
