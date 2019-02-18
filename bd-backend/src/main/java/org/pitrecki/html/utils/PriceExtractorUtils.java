package org.pitrecki.html.utils;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PriceExtractorUtils {

    private static final String EMPTY = "";

    public static String extractPrice(String s) {
        return s
                .replaceAll("[A-Za-z\\u0080-\\u9fff\n ]+", EMPTY)
                .replaceAll(",", ".");
    }
}
