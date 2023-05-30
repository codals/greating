package com.codals.greating.diy.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DiyRequestDto {
    private MultipartFile imgUpload;
    private String dietType;
    private String category;
    private String dietName;
    private int minCalorie;
    private int maxCalorie;
    private int minPrice;
    private int maxPrice;
    private String rice;
    private String riceOption;
    private String soup;
    private String soupOption;
    private String mainCheckbox;
    private String mainOption;
    private List<String> sideOptions;
    private List<String> additionalItems;
    private String comments;
}
