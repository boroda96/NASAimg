package org.example;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyTelegramBot extends TelegramLongPollingBot {
    private static final String BOT_TOKEN = "6098361032:AAERVK4xT5GVQiW0Nm17zY7DNZYKgTnajCE";
    private static final String BOT_USERNAME = "JavaFree10BOT_bot";
    private static final String URL = "https://api.nasa.gov/planetary/apod?api_key=sB21wxCV036Go5UmcsQSNOiAbQb6PsiGQ23JgaBP";
    private static long chatID;

    public MyTelegramBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

        @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            chatID = update.getMessage().getChatId();
            switch (update.getMessage().getText()){
                case "/start":
                    sendMessage("Привет я бот, который присылает картинку от NASA");
                    break;
                case  "/help":
                    sendMessage("Чтобы получить картинку от NASA, введи /give");
                    break;
                case "/give":
                    try {
                        sendMessage(Utils.getUrl(URL));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    sendMessage("Моя твоя Не понимай");
            }

        }

    }
    private void sendMessage(String text){
        SendMessage message = new SendMessage();
        message.setChatId(chatID);
        message.setText(text);
        try{
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }

    }
}
