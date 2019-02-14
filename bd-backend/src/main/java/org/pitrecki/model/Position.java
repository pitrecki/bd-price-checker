package org.pitrecki.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Position {
    private final String title;
    private final String author;
    private final BigDecimal price;
    private final Currency currency;
}
