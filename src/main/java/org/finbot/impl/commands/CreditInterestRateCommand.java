package org.finbot.impl.commands;

import lombok.RequiredArgsConstructor;
import org.finbot.Command;
import org.finbot.Output;
import org.finbot.UserTalk;
import org.finbot.service.CreditInterestRateService;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class CreditInterestRateCommand implements Command {

    private final CreditInterestRateService service;
    private static final String CALCULATE = "Рассчитать переплату по кредиту";
    private static final String ENTER_MONEY = "Введите сумму кредита";
    private static final String ENTER_ANNUAL_PERCENTAGE = "Введите годовой процент";
    private static final String ENTER_PERIOD = "Введите период в месяцах";
    private final List<String> userMessages = Arrays.asList(
            CALCULATE,
            ENTER_MONEY,
            ENTER_ANNUAL_PERCENTAGE,
            ENTER_PERIOD
    );

    @Override
    public void execute(UserTalk userTalk, Output output) {

    }

    @Override
    public boolean isMatched(UserTalk userTalk, String textCommand) {
        return userMessages.contains(textCommand);
    }
}
