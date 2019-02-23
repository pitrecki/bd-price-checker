package org.pitrecki.html.extractor.single;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthorSinglePageExtractor extends AbstractSingleElementExtractor<String> {

    public AuthorSinglePageExtractor(@Value("${single.page.author}") String authorXpath) {
        super(authorXpath);
    }
}
