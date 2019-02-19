package org.pitrecki.html.extractor;

public interface SinglePageExtractor<E> {
    E extract(String path);

}
