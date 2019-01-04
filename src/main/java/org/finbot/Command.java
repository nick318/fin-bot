package org.finbot;

import org.finbot.domain.Message;
import org.finbot.impl.messages.TalkHistory;

public interface Command {
    void execute(TalkHistory<Message> talkHistory, Output output);
    boolean isMatched(TalkHistory<Message> talkHistory, String textCommand);
}
