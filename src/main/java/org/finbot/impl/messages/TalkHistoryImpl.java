package org.finbot.impl.messages;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Nikita Salomatin
 * @Date 31.07.2018
 * @contact nsalomatin@hotmail.com
 */
public class TalkHistoryImpl<T> implements TalkHistory<T> {

    private List<T> history = new ArrayList<>();
    private final List<T> globalHistory = new ArrayList<>();

    @Override
    public T getLastMessage() {
        return history.get(history.size() - 1);
    }

    @Override
    public void addMessage(T message) {
        history.add(message);
        globalHistory.add(message);
    }

    @Override
    public int getSize() {
        return history.size();
    }

    @Override
    public void clear() {
        this.history = new ArrayList<>();
    }

    @Override
    public List<T> get() {
        return history;
    }

    @Override
    public List<T> getGlobal() {
        return globalHistory;
    }
}
