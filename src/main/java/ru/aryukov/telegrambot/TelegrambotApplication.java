package ru.aryukov.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import ru.aryukov.telegrambot.bot.controller.BotController;

@SpringBootApplication
public class TelegrambotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegrambotApplication.class, args);
    }

}
