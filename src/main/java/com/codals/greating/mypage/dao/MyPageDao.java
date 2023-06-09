package com.codals.greating.mypage.dao;

import java.util.List;


import com.codals.greating.mypage.dto.MyPageDto;
import com.codals.greating.mypage.dto.MyPageScrapDto;

public interface MyPageDao {

	List<MyPageDto> diyList(MyPageDto dto);

	List<MyPageDto> scrapList(MyPageScrapDto dto);

	List<MyPageDto> voteList(MyPageScrapDto dto);

	int getMyPostTotalPageCount(long userId);
	
	int getMyScrapTotalPageCount(long userId);
	
	int getMyVoteTotalPageCount(long userId);

	int deleteMyDiy(int postId);
}
