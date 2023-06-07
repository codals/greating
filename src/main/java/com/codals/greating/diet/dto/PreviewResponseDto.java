package com.codals.greating.diet.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Data;

@Data
public class PreviewResponseDto {

    private String startDate;
    private String endDate;
    private List<PreviewDietResponseDto> diets;

    public PreviewResponseDto(LocalDate startDate, List<PreviewDietResponseDto> diets) {
        this.startDate = startDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        this.endDate = startDate.plusDays(1).format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        this.diets = diets;
    }
}
