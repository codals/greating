package com.codals.greating.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codals.greating.mypage.dao.MyPageDao;
import com.codals.greating.mypage.dto.MyPageDto;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageDao dao;


	@Override
	public List<MyPageDto> diyList(MyPageDto dto) {
		// TODO Auto-generated method stub
		return dao.diyList(dto);
	}


	@Override
	public List<MyPageDto> scrapList(MyPageScrapDto dto) {
		// TODO Auto-generated method stub
		return dao.scrapList(dto);
	}


	@Override
	public List<MyPageDto> voteList(MyPageScrapDto dto) {
		// TODO Auto-generated method stub
		return dao.voteLlist(dto);
	}

}
