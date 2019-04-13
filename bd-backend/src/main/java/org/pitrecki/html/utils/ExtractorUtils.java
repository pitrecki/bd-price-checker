package org.pitrecki.html.utils;

import lombok.NoArgsConstructor;
import org.pitrecki.model.Currency;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static lombok.AccessLevel.PRIVATE;
import static org.pitrecki.model.Currency.fromString;

@NoArgsConstructor(access = PRIVATE)
public class ExtractorUtils {

    private static final String EMPTY = "";
    private static final String UTF_8 = "\\u0080-\\u9fff";

    private static final Pattern PRICE_PATTERN = compile("[A-Za-z&;" + UTF_8 + "\n ]+");
    private static final String NBSP = "&nbsp;";
    private static final Pattern CURRENCY_PATTERN = compile("[\\p{Lu}\\p{Digit}.," + NBSP + "\\s\\h]+");

    public static BigDecimal convertPrice(String s) {
        String price = PRICE_PATTERN.matcher(s)
                .replaceAll(EMPTY)
                .replaceAll(",", ".");
        return new BigDecimal(price);
    }

    public static Currency convertCurrency(String s) {
        String currency = CURRENCY_PATTERN.matcher(s).replaceAll(EMPTY);
        return fromString(currency);
    }

}
