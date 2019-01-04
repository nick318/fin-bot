package org.finbot.domain;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class TelegramMessage implements Message {

    private final Update update;

    @Override
    public Long getChatId() {
        return update.getMessage().getChat().getId();
    }

    @Override
    public String getText() {
        return update.getMessage().getText();
    }
}
