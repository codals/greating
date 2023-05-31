package com.codals.greating.diet.dto;

import com.codals.greating.diet.entity.Diet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.Data;

@Data
public class PlanResponseDto {

    private String deliveryDate;
    private List<PreviewDietResponseDto> diets;

    public PlanResponseDto(String deliveryDate, List<PreviewDietResponseDto> diets) {
        this.deliveryDate = deliveryDate;
        this.diets = diets;
    }
}
