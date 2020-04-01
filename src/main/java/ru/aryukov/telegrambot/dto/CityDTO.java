package ru.aryukov.telegrambot.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDTO {
    private Long id;
    private String name;
    private Set<AdviceDTO> advices;
}
