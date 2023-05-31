package com.codals.greating.mypage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codals.greating.mypage.dto.MyPageDto;
import com.codals.greating.mypage.dto.MyPageScrapDto;


public interface MyPageService {

	public List<MyPageDto> diyList(MyPageDto dto);

	public List<MyPageDto> scrapList(MyPageScrapDto dto);

	public List<MyPageDto> voteList(MyPageScrapDto dto);

}
