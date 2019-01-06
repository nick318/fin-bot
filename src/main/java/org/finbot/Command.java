package org.finbot;

public interface Command {
    void execute(UserTalk userTalk, Output output);

    boolean isMatched(UserTalk userTalk, String textCommand);
}
