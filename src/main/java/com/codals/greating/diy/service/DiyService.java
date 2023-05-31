package com.codals.greating.diy.service;

import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.VoteRequestDTO;

public interface DiyService {

	PostResponseDto getPostDetail(int postId);

	void createPost(DiyRequestDto newPost, String path);

	int votePost(VoteRequestDTO requestDTO);
	
}
