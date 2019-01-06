package org.finbot.service;

import org.finbot.domain.Money;
import org.finbot.domain.Percents;
import org.finbot.domain.PeriodOfRate;

public interface CreditInterestRateService {
    Money calculateInterestRateBy(Money money, Percents percents, PeriodOfRate periodOfRate);
}
