package com.codals.greating.diy.service;

import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.VoteRequestDto;

public interface DiyService {

	PostResponseDto getPostDetail(int postId);

	void createPost(DiyRequestDto newPost, String path);

	boolean vote(VoteRequestDto requestDTO);

	boolean cancelVote(VoteRequestDto requestDto);
	
}
