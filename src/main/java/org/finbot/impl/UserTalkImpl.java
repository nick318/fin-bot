package org.finbot.impl;

import lombok.RequiredArgsConstructor;
import org.finbot.Command;
import org.finbot.Output;
import org.finbot.UserTalk;
import org.finbot.domain.Message;
import org.finbot.domain.TelegramMessage;
import org.finbot.impl.messages.TalkHistory;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class UserTalkImpl implements UserTalk {
    private final List<Command> commands;
    private final TalkHistory<Message> talkHistory;
    private final Object chatId;
    private final Map<String, Object> params = new HashMap<>();

    @Override
    public void handleUpdate(Update update, Output output) {
        talkHistory.addMessage(new TelegramMessage(update));
        Command foundCommand = commands
                .stream()
                .filter(command -> command.isMatched(this, update.getMessage().getText()))
                .findAny()
                .orElse(new Command() {
                    @Override
                    public void execute(UserTalk userTalk, Output output) {
                        output.send("Команда не найдена");
                    }

                    @Override
                    public boolean isMatched(UserTalk userTalk, String textCommand) {
                        return false;
                    }
                });
        foundCommand.execute(this, output);
    }

    @Override
    public Map<String, Object> params() {
        return params;
    }

    @Override
    public TalkHistory<Message> talkHistory() {
        return talkHistory;
    }
}
