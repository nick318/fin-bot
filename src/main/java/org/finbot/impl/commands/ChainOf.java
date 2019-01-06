package org.finbot.impl.commands;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
class ChainOf<T> {

    private List<T> values;

    ChainOf(Collection<T> collection) {
        this.values = new ArrayList<>(collection);
    }

    ChainOf(T... args) {
        this.values = Arrays.asList(args);
    }

    public T getNextByCurrent(T value) {
        return values.get(values.indexOf(value) + 1);
    }
}
