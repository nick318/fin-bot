package org.finbot.impl;

import lombok.RequiredArgsConstructor;
import org.finbot.UserTalk;
import org.finbot.Command;
import org.finbot.Output;
import org.finbot.domain.Message;
import org.finbot.domain.TelegramMessage;
import org.finbot.impl.messages.TalkHistory;
import org.telegram.telegrambots.meta.api.objects.Update;
import java.util.List;

@RequiredArgsConstructor
public class UserTalkImpl implements UserTalk {
    private final List<Command> commands;
    private final TalkHistory<Message> talkHistory;

    @Override
    public void handleUpdate(Update update, Output output) {
        talkHistory.addMessage(new TelegramMessage(update));
        Command foundCommand = commands
                .stream()
                .filter(command -> command.isMatched(talkHistory, update.getMessage().getText()))
                .findAny()
                .orElse(new Command() {
                    @Override
                    public void execute(TalkHistory<Message> talkHistory, Output output) {
                        output.send("Команда не найдена");
                    }

                    @Override
                    public boolean isMatched(TalkHistory<Message> talkHistory, String textCommand) {
                        return false;
                    }
                });
        foundCommand.execute(talkHistory, output);
    }
}
