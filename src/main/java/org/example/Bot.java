package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private InlineKeyboardMarkup keyboardAttendance;

    private boolean start = false;
    private boolean help = false;
    private boolean homepage = false;

    @Override
    public String getBotUsername() {
        return "Pray For Gospel";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();

        try {
            execute(sm);
        } catch (TelegramApiException ex) {
            System.out.println(ex);
        }
    }

    public void sendMenu(Long who, String txt, InlineKeyboardMarkup kb) {
        SendMessage sm = SendMessage.builder().chatId(who.toString())
                .parseMode("HTML").text(txt)
                .replyMarkup(kb).build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            System.out.println(e);
        }
    }


    private void showHelp(Long id) {
        help = true;

        sendText(id, MessageResponseVietnamese.help_text);

//        var back = InlineKeyboardButton.builder()
//                .text("< Back").callbackData("back")
//                .build();
//
//        keyboardBack = InlineKeyboardMarkup.builder()
//                .keyboardRow(List.of(back)).build();
    }

    private void homepage(Long id) {
        homepage = true;

        var attend = InlineKeyboardButton.builder()
                .text("Điểm danh cầu nguyện").callbackData("attendance")
                .build();

        keyboardAttendance = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(attend)).build();

        sendMenu(id, MessageResponseVietnamese.greeting, keyboardAttendance);
    }

    private void buttonTap(Long id, String queryId, String data, int msgId, String fullName, Long userId) {
        EditMessageText newTxt = EditMessageText.builder()
                .chatId(id.toString())
                .messageId(msgId).text("").build();

        EditMessageReplyMarkup newKb = EditMessageReplyMarkup.builder()
                .chatId(id.toString()).messageId(msgId).build();

        if (data.equals("attendance")) {
            try {
                String selectQuery = "SELECT TotalPrayCountNumber FROM Users WHERE UserID=?";
                String insertQuery = "INSERT INTO Users(UserID, FullName, TotalPrayCountNumber, UserPrivilege) VALUES (?, ?, ?, ?)";
                String updateQuery = "UPDATE Users SET TotalPrayCountNumber=? WHERE UserID=?";

                try (PreparedStatement selectStmt = SQLInterface.conn.prepareStatement(selectQuery)) {
                    selectStmt.setLong(1, userId);
                    try (ResultSet rs = selectStmt.executeQuery()) {
                        if (rs.next()) {
                            int currentCount = rs.getInt("TotalPrayCountNumber");
                            int newCount = currentCount + 1;
                            try (PreparedStatement updateStmt = SQLInterface.conn.prepareStatement(updateQuery)) {
                                updateStmt.setInt(1, newCount);
                                updateStmt.setLong(2, userId);
                                updateStmt.executeUpdate();
                            }
                        } else {
                            try (PreparedStatement insertStmt = SQLInterface.conn.prepareStatement(insertQuery)) {
                                insertStmt.setLong(1, userId);
                                insertStmt.setString(2, fullName);
                                insertStmt.setInt(3, 1);
                                insertStmt.setInt(4, 0);
                                insertStmt.executeUpdate();
                            }
                        }
                    }
                } catch (SQLException ex) {
                    sendText(id, MessageResponseVietnamese.attendance_error + "\n\nDetails:\n" + ex);
                }
            } catch (Exception ex) {
                sendText(id, MessageResponseVietnamese.attendance_error + "\n\nDetails:\n" + ex + "\n" + ex.getCause() + "\n" + ex.getStackTrace());
            }
        }

        sendText(id, MessageResponseVietnamese.attendance_ok);

        // Close the callback query
        AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                .callbackQueryId(queryId)
                .build();

        try {
            execute(close);
        } catch (TelegramApiException ex) {
            System.out.println(ex);
        }
    }


    private void handleIncomingMessage(Message message) {
        Long chatId = message.getFrom().getId();

        if (message.getText().equals("/start")) {
            homepage(chatId);
        }
        else if (message.getText().equals("/help")) {
            showHelp(chatId);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleIncomingMessage(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            Long chatId = callbackQuery.getMessage().getChatId();
            int messageId = callbackQuery.getMessage().getMessageId();
            String queryId = callbackQuery.getId();

            String firstName = callbackQuery.getFrom().getFirstName();
            String lastName = callbackQuery.getFrom().getLastName();
            String fullName = firstName + " " + lastName;
            Long id = callbackQuery.getFrom().getId();

            buttonTap(chatId, queryId, data, messageId, fullName, id);
        }
    }
}
