package org.finbot.impl.commands;

import org.finbot.Command;
import org.finbot.Output;
import org.finbot.UserTalk;

public class HelloCommand implements Command {
    @Override
    public void execute(UserTalk userTalk, Output output) {
        output.send("Привет!");
    }

    @Override
    public boolean isMatched(UserTalk userTalk, String textCommand) {
        return "Начать".equals(textCommand) || "/start".equals(textCommand);
    }
}
