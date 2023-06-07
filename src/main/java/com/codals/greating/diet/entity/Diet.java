package com.codals.greating.diet.entity;

import java.util.LinkedHashMap;

import com.codals.greating.date.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public Diet(LinkedHashMap<String, Object> cachedMap) {
		this.id = (Integer) cachedMap.get("id");
		this.thumbnailImgUrl = (String) cachedMap.get("thumbnailImgUrl");
		this.name = (String) cachedMap.get("name");
		this.price = (Integer) cachedMap.get("price");
	}
    
    public Diet(Diet diet) {
    	
    }
}
