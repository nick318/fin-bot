package org.finbot;

import org.finbot.domain.Message;
import org.finbot.impl.messages.TalkHistory;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public interface UserTalk {
    void handleUpdate(Update update, Output output);

    Map<String, Object> params();

    TalkHistory<Message> talkHistory();
}
