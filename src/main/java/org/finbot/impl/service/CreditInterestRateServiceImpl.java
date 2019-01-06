package org.finbot.impl.service;

import org.finbot.domain.Money;
import org.finbot.domain.Percents;
import org.finbot.domain.PeriodOfRate;
import org.finbot.service.CreditInterestRateService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CreditInterestRateServiceImpl implements CreditInterestRateService {

    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    @Override
    public Money calculateInterestRateBy(Money money, Percents percents, PeriodOfRate periodOfRate) {
        return new Money(
                percents.getValue()
                        .multiply(periodOfRate.years())
                        .multiply(money.getValue())
                        .divide(ONE_HUNDRED, new MathContext(0, RoundingMode.HALF_UP))
                        .setScale(0, RoundingMode.DOWN),
                "$"
        );
    }
}
