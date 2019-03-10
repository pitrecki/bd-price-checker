package org.pitrecki.html.extractor.analyzer;

import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.pitrecki.html.extractor.ElementExtractor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class PageAnalyzer implements ElementExtractor<Boolean> {

    @Value("${grid.view.applicable}") private final List<String> xpaths;

    @Override
    public Boolean extract(Document document) {
        return xpaths.stream()
                .anyMatch(s -> document.select(s).hasText());
    }
}
