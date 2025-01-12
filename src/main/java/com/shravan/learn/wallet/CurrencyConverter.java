package com.shravan.learn.wallet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<Currency, BigDecimal> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put(Currency.USD, BigDecimal.ONE);
        exchangeRates.put(Currency.EUR, new BigDecimal("0.85"));
        exchangeRates.put(Currency.GBP, new BigDecimal("0.72"));
        exchangeRates.put(Currency.JPY, new BigDecimal("110.00"));
    }

    public static BigDecimal convert(BigDecimal amount, Currency source, Currency target) {
        BigDecimal sourceRate = exchangeRates.get(source);
        BigDecimal targetRate = exchangeRates.get(target);
        return amount.multiply(targetRate).divide(sourceRate, RoundingMode.HALF_UP);
    }
}
