package ru.aryukov.telegrambot.service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aryukov.telegrambot.domain.City;
import ru.aryukov.telegrambot.dto.AdviceDTO;
import ru.aryukov.telegrambot.dto.CityDTO;
import ru.aryukov.telegrambot.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void addCity(CityDTO cityDTO) {
        City newCity = new City();
        newCity.setName(cityDTO.getName());
        newCity.setAdvices(new HashSet<>());
        cityRepository.save(newCity);
    }

    @Override
    public void deleteCity(String name) {
        cityRepository.deleteByName(name);
    }

    @Override
    public List<CityDTO> getAllCity() {
        List<City> cities = cityRepository.findAll();
        List<CityDTO> cityDTOS = cities.stream()
                .map(city -> CityDTO.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .advices(city.getAdvices().stream()
                                .map(advice -> AdviceDTO.builder()
                                        .id(advice.getId())
                                        .content(advice.getContent())
                                        .build()).collect(Collectors.toSet()))
                        .build())
                .collect(Collectors.toList());
        return cityDTOS;
    }

    @Override
    public CityDTO findByName(String name) {
        City city = cityRepository.findByName(name);

        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .advices(city.getAdvices().stream()
                        .map(advice -> AdviceDTO.builder()
                                .id(advice.getId())
                                .content(advice.getContent())
                                .build()).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public City updateCity(Long id, String cityName) {
        cityRepository.findById(id).get().setName(cityName);
        return cityRepository.findById(id).get();
    }
}
