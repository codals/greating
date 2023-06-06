package com.codals.greating.diet.entity;

import com.codals.greating.date.BaseEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyDiet extends BaseEntity {

    private Integer id;
    private Integer dietId;
    private LocalDate startDate;
    private LocalDate endDate;
    
    private Diet diet;
    
    public DailyDiet(LinkedHashMap<String, Object> cachedMap) {
//    	this.id = (Integer) cachedMap.get("id");
    	this.dietId = (Integer) cachedMap.get("dietId");
    	this.startDate = LocalDate.parse((String) cachedMap.get("startDate"), DateTimeFormatter.ISO_DATE);
    	this.endDate = LocalDate.parse((String) cachedMap.get("endDate"), DateTimeFormatter.ISO_DATE);
        this.diet = new Diet((LinkedHashMap<String, Object>) cachedMap.get("diet"));
    }
}
