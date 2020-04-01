package ru.aryukov.telegrambot.service;

import java.util.List;

import ru.aryukov.telegrambot.domain.City;
import ru.aryukov.telegrambot.dto.CityDTO;


public interface CityService {

    void addCity(CityDTO cityDTO);
    void deleteCity(String name);
    List<CityDTO> getAllCity();
    CityDTO findByName(String name);
    City updateCity(Long id, String name);
}
