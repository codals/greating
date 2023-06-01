package com.codals.greating.diy.dao;

import java.util.List;

import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.dto.SearchRequestDto;
import com.codals.greating.diy.dto.SimplePostDto;
import com.codals.greating.diy.dto.VoteRequestDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.diy.entity.Scrap;
import com.codals.greating.diy.entity.Vote;

public interface DiyDAO {
	<Optional> PostResponseDto selectPostByPostId(int postId);
	
	Integer savePost(Post post);

	int insertScrap(ScrapRequestDto requestDto);
	int deleteScrap(ScrapRequestDto requestDto);
  
	int insertVote(VoteRequestDto requestDto) throws Exception;
	int deleteVote(VoteRequestDto requestDto) throws Exception;

	List<Post> selectPostsByMainCategory(int id);

	List<SimplePostDto> selectPostBySearchConditions(SearchRequestDto requestDto);

	Vote selectVoteByPostIdAndUserId(VoteRequestDto requestDto);

	Scrap selectScrapByPostIdAndUserId(ScrapRequestDto requestDto);
}
