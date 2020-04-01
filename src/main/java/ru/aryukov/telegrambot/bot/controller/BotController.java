package ru.aryukov.telegrambot.bot.controller;

import javax.persistence.Column;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.aryukov.telegrambot.dto.CityDTO;
import ru.aryukov.telegrambot.service.CityService;

@Component
public class BotController extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(BotController.class);
    private static final String NOT_FOUND_CITY = "Sorry we can not giveyou advice for this city";

    @Value("${bot.api-key}")
    private String token;

    @Value("${bot.username}")
    private String username;

    @Autowired
    private CityService cityService;

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            SendMessage response = new SendMessage();
            Long chatId = message.getChatId();
            response.setChatId(chatId);
            String text = message.getText();
            response.setText(getAdviceForCity(text));
            try {
                execute(response);
                logger.info("Sent message \"{}\" to {}", text, chatId);
            } catch (TelegramApiException e) {
                logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
            }
        }
    }


    private String getAdviceForCity(String cityName){
        StringBuffer stringBuffer = new StringBuffer();

        CityDTO cityDTO = cityService.findByName(cityName);
        if(cityDTO!=null){
            cityDTO.getAdvices().forEach(advice -> stringBuffer.append(advice + "\n"));
            return stringBuffer.toString();
        }
        return stringBuffer.append(NOT_FOUND_CITY).toString();
    }

    @Override
    public String getBotUsername() {
        return this.username;
    }
}
