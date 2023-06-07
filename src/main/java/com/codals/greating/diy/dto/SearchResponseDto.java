package com.codals.greating.diy.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResponseDto {
	private int page;
	private int totalCount;
	private int totalPage;
	private List<SimplePostDto> posts;
}
