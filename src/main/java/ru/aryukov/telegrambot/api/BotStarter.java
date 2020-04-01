package ru.aryukov.telegrambot.api;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import ru.aryukov.telegrambot.bot.controller.BotRegister;

@RestController
public class BotStarter {

    @Autowired
    private BotRegister botRegister;

    @GetMapping(path = "/startBot")
    public void startBot() throws TelegramApiRequestException {
        botRegister.init();
    }
}
