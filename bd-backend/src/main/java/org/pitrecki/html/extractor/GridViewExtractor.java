package org.pitrecki.html.extractor;

import java.util.Collection;

public interface GridViewExtractor<E> {
    Collection<E> extract(String path);

}
