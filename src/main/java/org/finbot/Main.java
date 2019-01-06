package org.finbot;

import org.finbot.impl.commands.CreditInterestRateCommand;
import org.finbot.impl.commands.HelloCommand;
import org.finbot.impl.messages.TalkContainer;
import org.finbot.impl.service.CreditInterestRateServiceImpl;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws TelegramApiRequestException {
        // Initialize Api Context
        ApiContextInitializer.init();
        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi();
        TelegramBot telegramBot =
                new TelegramBot(
                        new TalkContainer(
                                Arrays.asList(
                                        new HelloCommand(),
                                        new CreditInterestRateCommand(new CreditInterestRateServiceImpl())
                                )
                        )
                );
        botsApi.registerBot(telegramBot);
    }
}
