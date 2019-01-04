package org.finbot.impl.commands;

import org.finbot.Command;
import org.finbot.Output;
import org.finbot.domain.Message;
import org.finbot.impl.messages.TalkHistory;

public class HelloCommand implements Command {
    @Override
    public void execute(TalkHistory<Message> talkHistory, Output output) {
        output.send("Привет!");
    }

    @Override
    public boolean isMatched(TalkHistory<Message> talkHistory, String textCommand) {
        return "Начать".equals(textCommand) || "/start".equals(textCommand);
    }
}
