package org.finbot.impl;

import lombok.RequiredArgsConstructor;
import org.finbot.Output;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class TelegramBotOutput implements Output {

    private final Update update;
    private final DefaultAbsSender sender;

    @Override
    public void send(String message) {
        sendMessage(update.getMessage().getChatId().toString(), message);
    }

    private void sendMessage(String chatId, String s) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chatId);
        message.setText(s);
        try {
            KeyboardRow startRow = new KeyboardRow();
            startRow.add(new KeyboardButton("Начать"));
            KeyboardRow functions = new KeyboardRow();
            functions.add(new KeyboardButton("Рассчитать переплату по кредиту"));
            setButtons(message, Arrays.asList(startRow, functions));
            sender.execute(message);
        } catch (TelegramApiException e) {
            throw new OutputException("SendMessage was failed due: ", e);
        }
    }

    private void setButtons(SendMessage sendMessage, List<KeyboardRow> rows) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setKeyboard(rows);
    }
}
