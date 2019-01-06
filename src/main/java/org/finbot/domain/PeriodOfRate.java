package org.finbot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class PeriodOfRate {
    private final double months;

    public BigDecimal years() {
        return new BigDecimal(months / 12d);
    }
}
