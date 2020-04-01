package ru.aryukov.telegrambot.service;


import java.util.List;
import java.util.Set;

import ru.aryukov.telegrambot.domain.Advice;

public interface AdviceService {
    void addAdviceToCity(String name, String advice);
    Set<Advice> getAllAdvicesByCityName(String name);
    Advice updateAdvice(Long id, String advice);
    void deleteAdvice(Long id);
}
