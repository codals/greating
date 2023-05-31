package com.codals.greating.diy.dao;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.VoteRequestDto;
import com.codals.greating.diy.entity.Post;

public interface DiyDAO {
	<Optional> PostResponseDto selectPostByPostId(int postId);

	Integer savePost(Post post);

	int vote(VoteRequestDto requestDto) throws Exception;

	int cancelVote(VoteRequestDto requestDto) throws Exception;
}
