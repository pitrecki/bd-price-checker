package org.pitrecki.html.parser;

public interface SinglePageParser<E> {
    E extract(String path);

}
