package org.finbot;

import lombok.RequiredArgsConstructor;
import org.cactoos.text.TextOf;
import org.cactoos.text.UncheckedText;
import org.finbot.impl.TelegramBotOutput;
import org.finbot.impl.messages.TalkContainer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final TalkContainer talkContainer;

    public void onUpdateReceived(Update update) {
        UserTalk userTalk = talkContainer.getUserTalk(update.getMessage().getChatId());
        userTalk.handleUpdate(update, new TelegramBotOutput(update, this));
    }

    public String getBotUsername() {
        return "FinCalcBot";
    }

    public String getBotToken() {
        return new UncheckedText(
                new TextOf(
                        getClass().getClassLoader().getResourceAsStream("token.txt")
                )
        ).asString();
    }
}
