package org.finbot.impl.messages;

import lombok.RequiredArgsConstructor;
import org.finbot.Command;
import org.finbot.UserTalk;
import org.finbot.impl.UserTalkImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Nikita Salomatin
 * @Date 31.07.2018
 * @contact nsalomatin@hotmail.com
 */
@RequiredArgsConstructor
public final class TalkContainer {

    private Map<Object, UserTalk> chatId2UserTalk = new HashMap<>();
    private final List<Command> commands;

    public UserTalk getUserTalk(Object chatId) {
        this.chatId2UserTalk.putIfAbsent(chatId, new UserTalkImpl(commands, new TalkHistoryImpl<>(), chatId));
        return this.chatId2UserTalk.get(chatId);
    }


}
