package ru.aryukov.telegrambot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdviceDTO {
    private Long id;
    private String content;
}
