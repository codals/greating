package com.codals.greating.diy.dao;

import com.codals.greating.diy.dto.PostResponseDto;

public interface DiyDao {


	<Optional> PostResponseDto selectPostByPostId(int postId);
}
