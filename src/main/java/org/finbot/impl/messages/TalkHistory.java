package org.finbot.impl.messages;

import java.util.List;

public interface TalkHistory<T> {

    /**
     *
     * @param message
     */
    void addMessage(T message);

    T getLastMessage();

    int getSize();

    void clear();

    List<T> get();

    List<T> getGlobal();
}
