package com.codals.greating.diy.dao;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.entity.Post;

public interface DiyDAO {
	<Optional> PostResponseDto selectPostByPostId(int postId);

	Integer savePost(Post post);

	int insertScrap(ScrapRequestDto requestDto);
}
