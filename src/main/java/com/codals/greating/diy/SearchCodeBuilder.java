package com.codals.greating.diy;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.codals.greating.constant.FoodCountryCode;
import com.codals.greating.constant.MainCategoryCode;
import com.codals.greating.diy.dto.SearchRequestDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class SearchCodeBuilder {
	
	private final static String CODE_CONNECTOR = "-";
	
	public String buildCode(SearchRequestDto requestDto) {
	    StringBuilder resultBuilder = new StringBuilder();

	    // 1. 메인 카테고리 코드화
	    List<MainCategoryCode> categories = requestDto.getMainCategories();
	    if (categories != null) {
	    	String categoryCodes = categories.stream()
                    						 .map(MainCategoryCode::getCacheCode)
                    						 .collect(Collectors.joining("&"));
	    	resultBuilder.append(CODE_CONNECTOR);
	        resultBuilder.append(categoryCodes);
	    }
	    
	    // 2. 국가 스타일 코드화
	    List<FoodCountryCode> countries = requestDto.getFoodCountries();
	    if (countries != null) {
	    	String countryCodes = countries.stream()
                    .map(FoodCountryCode::getCacheCode)
                    .collect(Collectors.joining("&"));
	    	
	    	resultBuilder.append(CODE_CONNECTOR);
	    	resultBuilder.append(countryCodes);
	    }

	    // 3. 밥 포함 유무 코드화
	    String riceCode = convertToRiceCode(requestDto.getHasRice());
	    if (riceCode != null) {
	    	resultBuilder.append(CODE_CONNECTOR);
	        resultBuilder.append(riceCode);
	    }

	    // 4. 국 포함 유무 코드화
	    String soupCode = convertToSoupCode(requestDto.getHasSoup());
	    if (soupCode != null) {
	    	resultBuilder.append(CODE_CONNECTOR);
	        resultBuilder.append(soupCode);
	    }
	    
	    String searchCode = resultBuilder.toString().substring(1);
	    return searchCode;
	}

	
	private String convertToRiceCode(Integer hasRice) {
        return hasRice != null ? "R" + hasRice : null;
    }

    private String convertToSoupCode(Integer hasSoup) {
        return hasSoup != null ? "S" + hasSoup : null;
    }	
	
}
