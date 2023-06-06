package com.codals.greating.diy.service;

import java.util.List;

import com.codals.greating.diet.entity.MainCategory;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SearchRequestDto;
import com.codals.greating.diy.dto.SimplePostDto;
import com.codals.greating.diy.dto.VoteRequestDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.user.entity.User;

public interface DiyService {

	PostResponseDto getPostDetail(int postId);

	Integer savePost(User loginUser, DiyRequestDto newPost);

	boolean scrap(ScrapRequestDto requestDto);
	boolean cancelScrap(ScrapRequestDto requestDto);

	boolean vote(VoteRequestDto requestDTO);
	boolean cancelVote(VoteRequestDto requestDto);

	List<Post> loadPostsByCategoryType(int mainCategoryId);

	List<SimplePostDto> search(SearchRequestDto requestDto);

	boolean checkVoted(VoteRequestDto requestDto);

	boolean checkScrapped(ScrapRequestDto requestDto);

	List<SimplePostDto> getRelatedPosts(int subCategoryId);
	
}
