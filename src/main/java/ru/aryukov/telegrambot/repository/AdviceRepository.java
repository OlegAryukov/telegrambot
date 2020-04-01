package ru.aryukov.telegrambot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.aryukov.telegrambot.domain.Advice;

public interface AdviceRepository extends CrudRepository<Advice,Long> {

    List<Advice> findAllByCity_Name(String name);
}
