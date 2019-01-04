package org.finbot.impl.commands;

import lombok.RequiredArgsConstructor;
import org.finbot.Command;
import org.finbot.Output;
import org.finbot.domain.Message;
import org.finbot.impl.messages.TalkHistory;
import org.finbot.service.CreditInterestRateService;

@RequiredArgsConstructor
public class CreditInterestRateCommand implements Command {

    private final CreditInterestRateService service;

    @Override
    public void execute(TalkHistory<Message> talkHistory, Output output) {

    }

    @Override
    public boolean isMatched(TalkHistory<Message> talkHistory, String textCommand) {
        return "Рассчитать переплату по кредиту".equals(textCommand);
    }
}
