package org.pitrecki.html.parser;

import java.util.Collection;

public interface GridViewParser<E> {
    Collection<E> extract(String path);

}
