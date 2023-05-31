package com.codals.greating.diet.dto;

import com.codals.greating.diet.entity.Diet;
import lombok.Data;

@Data
public class PreviewDietResponseDto {

    private Integer dietId;
    private String thumbnailImgUrl;
    private String name;
    private String price;

    public PreviewDietResponseDto(Diet diet) {
        this.dietId = diet.getId();
        this.thumbnailImgUrl = diet.getThumbnailImgUrl();
        this.name = diet.getName();
        this.price = String.format("%,d", diet.getPrice());
    }
}
