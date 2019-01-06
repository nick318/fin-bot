package org.finbot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class Money {
    private final BigDecimal value;
    private final String currency;
}
