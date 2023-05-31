package com.codals.greating.diet.dto;

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
