package org.pitrecki.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
public enum Currency {
    AUD("$"),
    EUR("€"),
    USD("$"),
    GBP("£"),
    NZD("$"),
    SGD("$"),
    CAD("$"),
    CZK("Kč"),
    ILS("₪"),
    JPY("￥"),
    HKD("$"),
    NOK("Kr"),
    PLN("zł"),
    SEK("Kr"),
    CHF("CHF"),
    THB("฿"),
    DKK("Kr"),
    HUF("Ft"),
    TWD("$"),
    ZAR("R"),
    MXN("$"),
    ARS("$"),
    CLP("$"),
    IDR("Rp"),
    MYR("RM"),
    KRW("￦");

    @Getter private final String value;

    public static Currency fromString(String s) {
        return Arrays.stream(Currency.values())
                .filter(currency -> currency.value.equalsIgnoreCase(s))
                .findFirst()
                .orElse(null);
    }
}
