package com.codals.greating.mypage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codals.greating.mypage.dto.MyPageDto;


public interface MyPageService {

	public List<MyPageDto> diyList(MyPageDto dto);

}
