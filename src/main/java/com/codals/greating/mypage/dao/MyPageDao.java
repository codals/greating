package com.codals.greating.mypage.dao;

import java.util.List;


import com.codals.greating.mypage.dto.MyPageDto;

public interface MyPageDao {

	List<MyPageDto> diyList(MyPageDto dto);

}
