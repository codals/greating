package com.codals.greating.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.mypage.dto.MyPageDto;
import com.codals.greating.mypage.dto.MyPageScrapDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyPageDaoImpl implements MyPageDao {
	
	private final SqlSession sqlsession;
	
	@Override
	public List<MyPageDto> diyList(MyPageDto dto) {
	    return sqlsession.selectList("mypage.diyList", dto);
	}

	@Override
	public List<MyPageDto> scrapList(MyPageScrapDto dto) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("mypage.scrapList", dto);
	}

	@Override
	public List<MyPageDto> voteList(MyPageScrapDto dto) {
		// TODO Auto-generated method stub
		return sqlsession.selectList("mypage.voteList", dto);
	}


	@Override
	public int getMyPostTotalPageCount(long userId) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("mypage.getMyPostTotalPageCount", userId);
	}

	@Override
	public int getMyScrapTotalPageCount(long userId) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("mypage.getMyScrapTotalPageCount", userId);
	}

	@Override
	public int getMyVoteTotalPageCount(long userId) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("mypage.getMyVoteTotalPageCount", userId);
	}

	@Override
	public int deleteMyDiy(int postId) {
		return sqlsession.delete("mypage.deleteMyDiy", postId);
	}


}
