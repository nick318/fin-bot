package org.finbot.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeriodOfRateTest {

    @Test
    void shouldGetYearAsBigDecimalWithOneYear() {
        assertEquals("1", new PeriodOfRate(12).years().toPlainString());
    }

    @Test
    void shouldGetYearAsBigDecimalWithOneAndHalfYear() {
        assertEquals("1.5", new PeriodOfRate(18).years().toPlainString());
    }
}