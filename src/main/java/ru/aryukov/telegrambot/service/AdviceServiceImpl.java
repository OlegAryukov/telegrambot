package ru.aryukov.telegrambot.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aryukov.telegrambot.domain.Advice;
import ru.aryukov.telegrambot.domain.City;
import ru.aryukov.telegrambot.repository.AdviceRepository;
import ru.aryukov.telegrambot.repository.CityRepository;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceRepository adviceRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void addAdviceToCity(String cityName, String content) {
        City city = cityRepository.findByName(cityName);
        Advice advice = new Advice();
        advice.setContent(content);
        city.getAdvices().add(advice);
    }

    @Override
    public Set<Advice> getAllAdvicesByCityName(String cityName) {
        return cityRepository.findByName(cityName).getAdvices();
    }

    @Override
    public Advice updateAdvice(Long id, String advice) {
        adviceRepository.findById(id).get().setContent(advice);
        return adviceRepository.findById(id).get();
    }

    @Override
    public void deleteAdvice(Long id) {
        adviceRepository.deleteById(id);
    }
}
