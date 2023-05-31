package com.codals.greating.diy.dao;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.VoteRequestDTO;

public interface DiyDAO {
	<Optional> PostResponseDto selectPostByPostId(int postId);

	int processVote(VoteRequestDTO requestDTO) throws Exception;
}
