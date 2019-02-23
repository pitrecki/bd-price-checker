package org.pitrecki.html.extractor.single;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TitleSinglePageExtractor extends AbstractSingleElementExtractor<String> {

    public TitleSinglePageExtractor(@Value("${single.page.title}") String titleXpath) {
        super(titleXpath);
    }
}
