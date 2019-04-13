package org.pitrecki.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
@Data
@Builder(builderMethodName = "aPosition")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String title;
    private final String author;
    private final BigDecimal price;
    private final Currency currency;
}
