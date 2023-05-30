package com.codals.greating.diet.entity;

import com.codals.greating.date.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Diet extends BaseEntity {

    private Integer id;
    private Integer mainCategoryId;
    private Integer subCategoryId;
    private String name;
    private Integer amount;
    private String storageType;
    private String thumbnailImgUrl;
    private String contentImgUrl;
    private Integer calorie;
    private Integer price;

}
