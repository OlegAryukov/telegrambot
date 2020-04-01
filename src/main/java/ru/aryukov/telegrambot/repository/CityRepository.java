package ru.aryukov.telegrambot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.aryukov.telegrambot.domain.City;

public interface CityRepository extends CrudRepository<City, Long> {

    void deleteByName(String name);

    City findByName(String name);

    @Override
    List<City> findAll();
}
