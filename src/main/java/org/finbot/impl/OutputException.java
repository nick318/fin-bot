package org.finbot.impl;

public class OutputException extends RuntimeException {
    public OutputException(String message, Exception exception) {
        super(message, exception);
    }
}
