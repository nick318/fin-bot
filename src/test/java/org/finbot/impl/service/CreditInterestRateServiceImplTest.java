package org.finbot.impl.service;

import org.finbot.domain.Money;
import org.finbot.domain.Percents;
import org.finbot.domain.PeriodOfRate;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditInterestRateServiceImplTest {

    @Test
    void shouldCalculateInterestRateOneYear() {
        CreditInterestRateServiceImpl service = new CreditInterestRateServiceImpl();
        Money interestRate = service.calculateInterestRateBy(
                new Money(
                        new BigDecimal(100_000),
                        "$"
                ),
                new Percents(new BigDecimal(10)),
                new PeriodOfRate(12)
        );
        assertEquals(new BigDecimal(10_000), interestRate.getValue());
    }

    @Test
    void shouldCalculateInterestRateTwoMonths() {
        CreditInterestRateServiceImpl service = new CreditInterestRateServiceImpl();
        Money interestRate = service.calculateInterestRateBy(
                new Money(
                        new BigDecimal(100_000),
                        "$"
                ),
                new Percents(new BigDecimal(10)),
                new PeriodOfRate(2)
        );
        assertEquals("1666", interestRate.getValue().toPlainString());
    }

    @Test
    void shouldCalculateInterestRateFourteenMonths() {
        CreditInterestRateServiceImpl service = new CreditInterestRateServiceImpl();
        Money interestRate = service.calculateInterestRateBy(
                new Money(
                        new BigDecimal(100_000),
                        "$"
                ),
                new Percents(new BigDecimal(10)),
                new PeriodOfRate(14)
        );
        assertEquals("11666", interestRate.getValue().toPlainString());
    }

    @Test
    void shouldCalculateInterestRateTwoYears() {
        CreditInterestRateServiceImpl service = new CreditInterestRateServiceImpl();
        Money interestRate = service.calculateInterestRateBy(
                new Money(
                        new BigDecimal(100_000),
                        "$"
                ),
                new Percents(new BigDecimal(10)),
                new PeriodOfRate(24)
        );
        assertEquals("20000", interestRate.getValue().toPlainString());
    }
}