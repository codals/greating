package com.codals.greating.diy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.codals.greating.diy.entity.Food;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DiyDAOImpl implements DiyDAO {
	private final SqlSession session;
	
}
