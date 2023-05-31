package com.codals.greating.diy.dao;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.VoteRequestDto;

public interface DiyDAO {
	<Optional> PostResponseDto selectPostByPostId(int postId);

	int vote(VoteRequestDto requestDto) throws Exception;

	int cancelVote(VoteRequestDto requestDto) throws Exception;
}
