package org.finbot;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UserTalk {
    void handleUpdate(Update update, Output output);
}
