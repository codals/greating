package com.codals.greating.diy.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiyRequestDto {
    private MultipartFile imgUpload;
    private String dietType;
    private String category;
    private String dietName;
    private Integer minCalorie;
    private Integer maxCalorie;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer riceFoodId;
    private Integer soupFoodId;
    private Integer mainFoodId;
    private List<Integer> sideFoodIds;
    private List<String> additionalItems;
    private String content;   
    
    public void setMinCalorie(String minCalorie) {
		this.minCalorie = Integer.valueOf(minCalorie);
	}
    
    public void setMaxCalorie(String maxCalorie) {
    	this.maxCalorie = Integer.valueOf(maxCalorie);
    }
    
    public void setMinPrice(String minPrice) {
    	this.minPrice = Integer.valueOf(minPrice);
    }
    
    public void setMaxPrice(String maxPrice) {
    	this.maxPrice = Integer.valueOf(maxPrice);
    }

	public void setRiceFoodId(String riceFoodId) {
        this.riceFoodId = Integer.valueOf(riceFoodId);
    }

    public void setSoupFoodId(String soupFoodId) {
        this.soupFoodId = Integer.valueOf(soupFoodId);
    }

    public void setMainFoodId(String mainFoodId) {
        this.mainFoodId = Integer.valueOf(mainFoodId);
    }

	public void setSideFoodIds(List<String> sideFoodIds) {
		this.sideFoodIds = sideFoodIds.stream()
									  .map(Integer::valueOf)
									  .collect(Collectors.toList());
	}

}
